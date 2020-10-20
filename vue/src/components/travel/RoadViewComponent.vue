<template>
  <v-row class="ma-0">
    <v-navigation-drawer
      v-model="drawer"
      height="700"
      temporary
      dark
      id="drawer"
    >
      <v-list-item light style="background-color: darkorange">
        <v-list-item-content>
          <v-list-item-title class="mt-4"
            ><b>내가 찾은 목록</b></v-list-item-title
          >
        </v-list-item-content>
      </v-list-item>

      <v-list dense class="mt-4">
        <v-list-item v-for="(item, i) in getFindItems" :key="i" link>
          <v-list-item-content>
            <v-list-item-title
              v-model="getInputLabels"
              class="mt-2 text-body-2"
              v-if="getValidItems[i]"
              >{{ getInputLabels[i] }}
            </v-list-item-title>
            <v-list-item-title class="mt-2 text-body-2" v-else
              >{{ getInputLabels[i] }}
              <v-tooltip right>
                <template v-slot:activator="{ on, attrs }">
                  <v-icon
                    style="margin-bottom: 2px"
                    dark
                    small
                    color="warning"
                    v-bind="attrs"
                    v-on="on"
                    @click="setItemsLabelAndValid(i, $event)"
                    >fas fa-exclamation-circle
                  </v-icon>
                </template>
                <span class="text-caption"
                  >혹시 {{ item.label }} 아닌가요?</span
                >
              </v-tooltip>
            </v-list-item-title>

            <v-divider class="ma-0 mt-2" />
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <div id="roadView">
      <canvas id="canvas"></canvas>
    </div>
    <v-footer id="bottomNav" absolute dark>
      <v-btn class="mr-12" @click.stop="drawer = !drawer">
        <v-icon>fas fa-list-ol</v-icon>
      </v-btn>
      <v-spacer></v-spacer>

      <v-btn color="error" fab dark depressed @click="capture">
        <v-icon>fas fa-camera</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <v-hover v-slot:default="{ hover }">
        <v-btn
          v-if="hover"
          @click="
            submit();
            dialog = true;
          "
          color="orange"
        >
          <v-icon left>fas fa-hand-paper</v-icon>
          <span>다했어요!</span>
        </v-btn>
        <v-btn v-else>
          <v-icon left>fas fa-hand-paper</v-icon>
          <span>다했어요!</span>
        </v-btn>
      </v-hover>
      <v-dialog v-model="dialog" persistent max-width="290">
        <v-card>
          <v-card-title class="headline">탐험 종료!</v-card-title>
          <v-card-text
            >{{ 100 * this.getValidItems.filter(i => i === true).length }}
            포인트가 적립되었습니다.
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="orange"
              text
              to="/"
              >나가기
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-footer>
  </v-row>
</template>

<script>
import kakaomapApi from "@/api/kakaomapApi";
import swal from 'sweetalert';

export default {
  name: "RoadViewComponent",
  data() {
    return {
      member: [],
      canvas: null,
      roadViewClient: null,
      roadViewPosition: null,
      mousedown: false,
      isCapture: false,
      drawer: false,
      canvasX: "",
      canvasY: "",
      startMouseX: 0,
      startMouseY: 0,
      endMouseX: 0,
      endMouseY: 0,
      ctx: null,
      viewpoint: null,
      roadView: null,
      label: "",
      acc: 0,
      validItems: this.getValidItems,
      findItems: this.getFindItems,
      inputLabels: this.getInputLabels,
      errorMessage: "",
      dialog: false,
      isComplete: false,
      point: 0,
    };
  },
  watch: {
    dialog(val) {
      if (!val) return;
      setTimeout(() => (this.dialog = false), 10000);
    },
  },
  mounted: async function() {
    await this.initCanvas();
    this.member = this.getMember;
    this.roadViewContainer = document.getElementById("roadView");
    await kakaomapApi.initRoadView(this);
    addEventListener("resize", e => {
      this.initCanvas();
    });
    this.canvas.addEventListener("mousedown", e => {
      this.startMouseX = parseInt(e.clientX - this.canvasX);
      this.startMouseY = parseInt(e.clientY - this.canvasY);
      this.viewpoint = this.roadView.getViewpointWithPanoId();
      this.mousedown = true;
    });
    this.canvas.addEventListener("mousemove", e => {
      this.endMouseX = parseInt(e.clientX - this.canvasX);
      this.endMouseY = parseInt(e.clientY - this.canvasY);
      if (this.mousedown) {
        this.ctx.clearRect(0, 0, $(window).width(), $(window).height());
        this.ctx.beginPath();
        let calcWidth = this.endMouseX - this.startMouseX;
        let calcHeight = this.endMouseY - this.startMouseY;
        this.ctx.rect(
          this.startMouseX,
          this.startMouseY,
          calcWidth,
          calcHeight,
        );

        this.ctx.fillStyle = "white";
        this.ctx.globalAlpha = "0.2";
        this.ctx.fill();
        this.ctx.strokeStyle = "white";
        this.ctx.lineWidth = 1.5;
        this.ctx.globalAlpha = "1";
        this.ctx.stroke();
      }
    });
    await this.canvas.addEventListener("mouseup", e => {
      this.mousedown = false;
      setTimeout(() => {
        this.capture();
      }, 50);
      const label = this.inputLabelPopup();
      let x1 = this.startMouseX;
      let x2 = this.endMouseX;
      let y1 = this.startMouseY;
      let y2 = this.endMouseY;
      const vm = this;
      this.$http
        .get(
          "http://127.0.0.1:5000/capture?panoId=" +
            this.viewpoint.panoId +
            "&pan=" +
            this.viewpoint.pan +
            "&tilt=" +
            this.viewpoint.tilt +
            "&zoom=" +
            this.viewpoint.zoom +
            "&label=" +
            label +
            "&w=" +
            this.canvas.width +
            "&h=" +
            this.canvas.height +
            "&x1=" +
            x1 +
            "&x2=" +
            x2 +
            "&y1=" +
            y1 +
            "&y2=" +
            y2,
        )
        .then(response => {
          vm.$store.dispatch("addFindItem", {
            label: response.data.name,
            acc: response.data.acc.toFixed(2),
            valid: response.data.name === label ? true : response.data.acc < 30,
            input: label,
          });
          return response;
        })
        .catch(err => {
          if (err.message.includes("Network Error")) {
          } else {
            console.log(err);
          }
        });
    });
  },
  computed: {
    getInputLabels() {
      const vm = this;
      vm.inputLabels = vm.$store.getters.getInputLabels;
      return vm.$store.getters.getInputLabels;
    },
    getValidItems() {
      const vm = this;
      vm.validItems = vm.$store.getters.getValidItems;
      return vm.$store.getters.getValidItems;
    },
    getFindItems() {
      const vm = this;
      vm.findItems = vm.$store.getters.getFindItems;
      return vm.$store.getters.getFindItems;
    },
    getMember() {
      const vm = this;
      vm.member = vm.$store.getters.getMember;
      return vm.$store.getters.getMember;
    },
  },
  methods: {
    initCanvas() {
      this.canvas = document.getElementById("canvas");
      this.canvas.style.zIndex = -1;
      this.ctx = this.canvas.getContext("2d", { alpha: false });
      this.canvas.width = window.innerWidth;
      this.canvas.height = window.innerHeight * 0.9505;
      this.canvasX = $(canvas).offset().left;
      this.canvasY = $(canvas).offset().top;
    },
    capture() {
      this.isCapture = true;
      this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
      this.canvas.style.zIndex *= -1;
    },
     inputLabelPopup() {
      let label = prompt("물체의 이름을 입력해주세요.", "");
      //  swal("물체의 이름을 입력해주세요.", {
      //   content: "input",
      // }).then(value => {
      //   return value;
      // })
      if (label == null || label === "") {
        return "";
      }
      return label;
    },
    setItemsLabelAndValid: function(idx, ev) {
      const vm = this;
      console.log(this.getFindItems[idx].label);
      vm.$store.dispatch("setItemsLabelAndValid", {
        label: this.getFindItems[idx].label,
        idx: idx,
      });
      vm.$forceUpdate();
    },
    submit() {
      let matchedCount = this.validItems.filter(i => i === true).length;
      let id = this.member.id;
      this.$store
        .dispatch("submit", { count: matchedCount, id: id })
        .then(response => {
          setTimeout(() => {
            this.$router.push("/");
          }, 10000);
        })
        .catch(error => {
          this.errorMessage = this.$store.state.errorMessage;
          console.log(error);
        });
    },
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.initCanvas);
  },
};
</script>

<style scoped>
#roadView {
  position: absolute;
  height: 93%;
  width: 100%;
  z-index: 0;
}

#canvas {
  position: absolute;
  top: auto;
  left: auto;
  height: 100%;
  width: 100%;
  cursor: crosshair;
  border: 1px solid #000000;
  z-index: 1;
}

#bottomNav {
  position: absolute;
  background-color: rgba(0, 0, 0, 0.5);
  backdrop-filter: blur(30px);
}

#drawer {
  background-color: rgba(0, 0, 0, 0.5);
  backdrop-filter: blur(30px);
}

.v-btn--outlined .v-btn__content .v-icon,
.v-btn--round .v-btn__content .v-icon {
  color: white !important;
}
</style>
