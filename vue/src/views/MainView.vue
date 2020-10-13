<template>
  <v-main>
    <main-nav-component />
    <cover-component />
    <test-component />
  </v-main>
</template>

<script>
import MainNavComponent from "@/components/common/MainNavComponent";
import CoverComponent from "@/components/main/CoverComponent";
import TestComponent from "@/components/main/TestComponent";

export default {
  name: "MainView",
  components: {
    MainNavComponent,
    CoverComponent,
    TestComponent,
  },
  data() {
    return {
      // msg: "Welcome to Your Vue.js App",
    };
  },
};
</script>

<style scoped></style>
