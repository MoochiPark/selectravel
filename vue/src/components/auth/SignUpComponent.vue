<template>
  <v-container>
    <v-row justify="center">
      <v-col lg="5" md="12" class="pa-16">
        <h2 class="text-center mb-8"><b>계정 만들기</b></h2>
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
          <p class="text-caption">
            Facebook/Google/Github으로 계정을 만들면 <br />이용약관에 동의한
            것으로 처리됩니다.
          </p>
          <v-divider class="mb-12" />
        </div>
        <v-form v-model="valid">
          <v-text-field
            v-model="name"
            :rules="nameRules"
            label="이름"
            dense
            outlined
          ></v-text-field>
          <v-text-field
            v-model="email"
            :rules="emailRules"
            label="이메일"
            dense
            outlined
          ></v-text-field>
          <div class="text-right"></div>
          <v-text-field
            v-model="password"
            :rules="passwordRules"
            :type="show ? 'text' : 'password'"
            @click:append="show = !show"
            label="비밀번호"
            dense
            outlined
          ></v-text-field>
          <v-text-field
            v-model="password"
            :rules="passwordRules"
            :type="show ? 'text' : 'password'"
            @click:append="show = !show"
            label="비밀번호확인"
            dense
            outlined
          ></v-text-field>
          <v-btn
            @click="signUp"
            large
            block
            color="orange"
            class="mb-5"
            :disabled="!valid"
            ><b>계정 만들기</b></v-btn
          >
        </v-form>
        <div class="text-center">
          <p class="grey--text">
            이미 계정이 있으신가요?
            <router-link to="/login" tag="b" style="cursor: pointer">
              <b class="ml-1" style="color: black">로그인 하기</b>
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
    show: false,
    valid: true,
    email: "",
    emailRules: [
      v => !!v || "이메일을 반드시 입력해주세요",
      v => /.+@.+\..+/.test(v) || "이메일 형식에 맞춰서 입력해주세요",
    ],
    password: "",
    passwordRules: [
      v => !!v || "비밀번호를 반드시 입력해주세요",
      v => v.length >= 7 || "최소 7 글자 이상 입력해주세요.",
    ],
  }),
  // methods: {
  //   async login() {
  //     const data = {
  //       email: this.email,
  //       password: this.password,
  //     };
  //   },
};
</script>

<style scoped></style>
