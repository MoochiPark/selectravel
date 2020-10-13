<template>
  <b-navbar type="dark" toggleable="sm" id="mainNav" sticky="true">
    <b-navbar-brand>
      <router-link class="logo" to="/" tag="span" style="cursor: pointer">
        {{ appTitle }}
      </router-link>
    </b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item to="/signup"><b>계정 만들기</b></b-nav-item>
        <b-nav-item to="/login"><b>로그인</b></b-nav-item>
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
};
</script>

<style scoped>
#mainNav {
  background-color: black;
  height: 60px;
}

.logo {
  font-family: "Origram", sans-serif;
  font-size: 1.5rem;
}
</style>
