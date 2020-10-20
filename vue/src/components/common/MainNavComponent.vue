<template>
  <b-navbar type="dark" toggleable="sm" id="authNav">
    <b-navbar-brand>
      <router-link class="logo" to="/" tag="span" style="cursor: pointer">
        {{ appTitle }}
      </router-link>
    </b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav class="ml-auto" v-if="!isLoggedIn">
        <b-nav-item to="/signup"><b>계정 만들기</b></b-nav-item>
        <b-nav-item to="/login"><b>로그인</b></b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto" v-if="isLoggedIn">
        <b-nav-item to="/profile"
          ><b>{{ currentMemberName }}님 환영합니다.</b></b-nav-item
        >
        <b-nav-item to="/gifticons"><b>교환소</b></b-nav-item>
        <b-nav-item @click="logout"><b>로그아웃</b></b-nav-item>
      </b-navbar-nav>
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
  computed: {
    currentMemberName() {
      return this.$store.state.memberName;
    },
    isLoggedIn() {
      return this.$store.getters.isLoggedIn;
    },
  },
  methods: {
    logout() {
      this.$store.dispatch("logout");
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
#authNav {
  background-color: black;
}

.logo {
  font-family: "Origram", sans-serif;
  font-size: 1.5rem;
}
</style>
