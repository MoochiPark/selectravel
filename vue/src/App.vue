<template>
  <v-app id="app">
    <router-view name="body" />
  </v-app>
</template>

<script>
export default {
  name: "App",
  created() {
    this.$http.interceptors.response.use(undefined, function(err) {
      return new Promise(function(resolve, reject) {
        if (err.status === 401 && err.config && !err.config.__isRetryRequest) {
          this.$store.dispatch("logout");
        }
        throw err;
      });
    });
  },
};
</script>

<style>
@font-face {
  font-family: "Origram";
  src: local("Origram"), url(~@/assets/fonts/Origram.ttf) format("truetype");
}

.v-btn--outlined .v-btn__content .v-icon,
.v-btn--round .v-btn__content .v-icon {
  color: orange !important;
}

.theme--light.v-btn.v-btn--icon {
  color: orange !important;
}

.v-btn:not(.v-btn--text):not(.v-btn--outlined).v-btn--active:before {
  opacity: 1 !important;
}

.v-btn--icon.v-size--small {
  height: 18px !important;
  width: 18px !important;
}
</style>
