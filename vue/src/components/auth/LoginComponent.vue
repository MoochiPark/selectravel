<template>
  <v-container>
    <v-row justify="center">
      <v-snackbar
        color="orange"
        centered
        v-model="snackbar"
        :timeout="3000"
        light
      >
        <div class="text-center">
          <b>{{ errorMessage }}</b>
        </div>
      </v-snackbar>
      <v-col lg="5" md="8" class="pa-16">
        <h2 class="text-center mb-8"><b>로그인</b></h2>
        <div class="text-center">
          <v-btn class="mb-3" color="blue darken-3" large block dark>
            <v-icon left dark>fab fa-facebook</v-icon>
            Facebook으로 계속하기
          </v-btn>
          <v-btn class="mb-3" color="red darken-3" large block dark>
            <v-icon left dark>fab fa-google</v-icon>
            Google으로 계속하기
          </v-btn>
          <v-btn class="mb-8" color="black" large block dark>
            <v-icon left dark>fab fa-github</v-icon>
            Github으로 계속하기
          </v-btn>
          <v-divider class="mb-12" />
        </div>
        <v-form v-model="valid" @submit.prevent="login">
          <v-text-field
            v-model="email"
            :rules="emailRules"
            label="이메일"
            dense
            outlined
            required
          ></v-text-field>
          <div class="text-right">
            <v-btn color="orange" to="/api/auth/reset" text>
              비밀번호 재설정
            </v-btn>
          </div>
          <v-text-field
            v-model="password"
            :rules="passwordRules"
            :type="show ? 'text' : 'password'"
            @click:append="show = !show"
            label="비밀번호"
            dense
            outlined
            required
          ></v-text-field>
          <v-btn
            type="submit"
            large
            block
            color="orange"
            class="mb-5"
            :disabled="!valid"
            ><b>로그인 하기</b></v-btn
          >
        </v-form>
        <div class="text-center">
          <p class="grey--text">
            아직 계정이 없으신가요?
            <router-link to="/signup" tag="b" style="cursor: pointer">
              <b class="ml-1" style="color: black">계정 만들기 </b>
            </router-link>
          </p>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    email: "",
    password: "",
    snackbar: false,
    errorMessage: "",
    valid: true,
    show: false,
    emailRules: [
      v => !!v || "이메일을 반드시 입력해주세요",
      v => /.+@.+\..+/.test(v) || "이메일 형식에 맞춰서 입력해주세요",
    ],
    passwordRules: [
      v => !!v || "비밀번호를 반드시 입력해주세요",
      v => v.length >= 7 || "최소 7 글자 이상 입력해주세요.",
    ],
  }),
  methods: {
    login() {
      let email = this.email;
      let password = this.password;
      this.$store
        .dispatch("login", { email, password })
        .then(() => {
          this.$router.push("/");
        })
        .catch(error => {
          this.snackbar = true;
          this.errorMessage = this.$store.state.errorMessage;
          console.log(error);
        });
    },
  },
};
</script>

<style scoped></style>
