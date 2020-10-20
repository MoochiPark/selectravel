<template>
  <v-main>
    <main-nav-component />
    <cover-component />
    <quest-carousel-component />
  </v-main>
</template>

<script>
import MainNavComponent from "@/components/common/MainNavComponent";
import CoverComponent from "@/components/main/CoverComponent";
import QuestCarouselComponent from "@/components/main/MissionCarouselComponent";

export default {
  name: "MainView",
  components: {
    MainNavComponent,
    CoverComponent,
    QuestCarouselComponent,
  },
  data() {
    return {
      // msg: "Welcome to Your Vue.js App",
    };
  },
};
</script>

<style scoped></style>
