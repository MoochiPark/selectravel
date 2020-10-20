<template>
  <v-main>
    <travel-nav-component />
    <road-view-component />
  </v-main>
</template>

<script>
import RoadViewComponent from "@/components/travel/RoadViewComponent";
import TravelNavComponent from "@/components/common/TravelNavComponent";

export default {
  name: "TravelView",
  components: {
    TravelNavComponent,
    RoadViewComponent,
  },
};
</script>

<style scoped></style>
