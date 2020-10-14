<template>
  <v-app id="app">
    <router-view name="body" />
  </v-app>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
@font-face {
  font-family: "Origram";
  src: local("Origram"), url(~@/assets/fonts/Origram.ttf) format("truetype");
}
</style>
