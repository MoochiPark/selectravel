<template>
  <b-navbar type="light" toggleable="sm" id="authNav">
    <b-navbar-brand>
      <router-link class="logo" to="/" tag="span" style="cursor: pointer">
        {{ appTitle }}
      </router-link>
    </b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <!--      v-if="!currentUser"-->
      <b-navbar-nav class="ml-auto">
        <b-nav-item to="/login"><b>개발자 로그인</b></b-nav-item>
        <b-nav-item to="/"><b>기업 계정 로그인</b></b-nav-item>
      </b-navbar-nav>
      <!--      <b-navbar-nav class="ml-auto" v-if="currentUser">-->
      <!--        <b-nav-item to="/profile"-->
      <!--          ><b>{{ currentUser.username }}</b></b-nav-item-->
      <!--        >-->
      <!--        <b-nav-item @click="logOut"><b>로그아웃</b></b-nav-item>-->
      <!--      </b-navbar-nav>-->
    </b-collapse>
  </b-navbar>
</template>
<script>
export default {
  name: "MainNavComponent",
  data() {
    return {
      appTitle: "selectravel",
    };
  },
  // computed: {
  //   currentUser() {
  //     return this.$store.state.auth?.user;
  //   },
  // },
  // methods: {
  //   logOut() {
  //     this.$store.dispatch("auth/logout");
  //     this.$router.push("/");
  //   },
  // },
};
</script>

<style scoped>
#authNav {
  background-color: white;
}

.logo {
  font-family: "Origram", sans-serif;
  font-size: 1.5rem;
}
</style>
