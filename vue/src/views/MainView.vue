<template>
  <v-main>
    <main-nav-component />
    <cover-component />
  </v-main>
</template>

<script>
import MainNavComponent from "@/components/common/MainNavComponent";
import CoverComponent from "@/components/main/CoverComponent";

export default {
  name: "MainView",
  components: {
    MainNavComponent,
    CoverComponent,
  },
  data() {
    return {
      // msg: "Welcome to Your Vue.js App",
    };
  },
};
</script>

<style scoped></style>
