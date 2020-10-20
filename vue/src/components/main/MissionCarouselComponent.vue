<template>
  <v-flex class="ma-8 mt-16">
    <h4>
      <b>진행중인 미션</b>
      <v-btn class="ml-4 mb-1" outlined color="orange"><b>더보기</b></v-btn>
    </h4>

    <v-carousel
      delimiter-icon="far fa-circle"
      hide-delimiter-background
      :show-arrows="false"
      light
      height="100%"
    >
      <v-carousel-item class="mb-16" v-for="i in idxList" :key="i" light>
        <b-container>
          <b-row align-h="center" cols="1" cols-lg="2" justify="center">
            <b-col md="10" lg="6" class="pa-4">
              <v-card class="mx-auto" max-width="700">
                <v-img
                  class="white--text align-end"
                  height="250px"
                  v-bind:src="missionInfo[i].image"
                  data-holder-rendered="ture"
                >
                </v-img>
                <v-card-title
                  ><b>{{ missionInfo[i].title }}</b></v-card-title
                >

                <v-card-subtitle class="pb-0">
                  <b>{{ missionInfo[i].company }}</b>
                </v-card-subtitle>

                <v-card-text class="text--primary">
                  <div>{{ missionInfo[i].description }}</div>
                  <div>기간: {{ missionInfo[i].duration }}</div>
                </v-card-text>

                <v-card-actions>
                  <v-btn
                    color="orange"
                    text
                    v-if="missionInfo[i].isProgress === true"
                  >
                    진행중
                  </v-btn>
                  <v-btn color="orange" disabled text v-else>
                    진행종료
                  </v-btn>
                </v-card-actions>
              </v-card>
            </b-col>
            <b-col md="10" lg="6" class="pa-4" v-if="missionInfo.length >= i + i">
              <v-card class="mx-auto" max-width="700">
                <v-img
                  class="white--text align-end"
                  height="250px"
                  v-bind:src="missionInfo[i + 1].image"
                >
                </v-img>
                <v-card-title
                  ><b>{{ missionInfo[i + 1].title }}</b></v-card-title
                >

                <v-card-subtitle class="pb-0">
                  <b>{{ missionInfo[i + 1].company }}</b>
                </v-card-subtitle>

                <v-card-text class="text--primary">
                  <div>{{ missionInfo[i + 1].description }}</div>
                  <div>기간: {{ missionInfo[i + 1].duration }}</div>
                </v-card-text>

                <v-card-actions>
                  <v-btn
                    color="orange"
                    text
                    v-if="missionInfo[i + 1].isProgress === true"
                  >
                    진행중
                  </v-btn>
                  <v-btn color="orange" disabled text v-else>
                    진행종료
                  </v-btn>
                </v-card-actions>
              </v-card>
            </b-col>
          </b-row>
        </b-container>
      </v-carousel-item>
    </v-carousel>
  </v-flex>
</template>

<script>
import config from "@/config/api.config";

export default {
  name: "MissionCarouselComponent",
  data() {
    return {
      idxList: [],
      missionInfo: [
        {
          image: "",
        },
      ],
    };
  },
  mounted() {
    this.getMissionInfo();
  },
  methods: {
    getMissionInfo() {
      this.$http
        .get(config.missionsUrl)
        .then(response => {
          this.missionInfo = response.data.content;
          for (let i = 0; i < this.missionInfo.length; i++) {
            this.missionInfo[i].image =
              config.missionsUrl + "/" + this.missionInfo[i].id + "/image";
          }
          this.idxList = this.list();
        })
        .catch(err => {
          if (err.message.includes("Network Error")) {
          } else {
            console.log(err);
          }
        });
    },
    list() {
      let list = [];
      for (let i = 0; i < this.missionInfo.length; i += 2) {
        list.push(i);
      }
      console.log(list);
      return list;
    },
  },
};
</script>

<style scoped></style>
