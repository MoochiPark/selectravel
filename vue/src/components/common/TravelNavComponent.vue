<template>
  <b-navbar type="dark" toggleable="sm" id="authNav" class="shadow">
    <b-navbar-brand>
      <router-link class="logo" to="/" tag="span" style="cursor: pointer">
        {{ appTitle }}
      </router-link>

      <v-btn text dark disabled><b class="text-white-50">자유탐험</b></v-btn>

    </b-navbar-brand>
    <!--    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>-->
    <b-navbar-nav class="ml-auto">
      <b-nav-item to="/help"><b>도움말</b></b-nav-item>
    </b-navbar-nav>
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
  computed: {},
};
</script>

<style scoped>
#authNav {
  background-color: black;
  z-index: 100;
}

.logo {
  font-family: "Origram", sans-serif;
  font-size: 1.5rem;
}
</style>
