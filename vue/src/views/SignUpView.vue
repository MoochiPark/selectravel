<template>
  <v-main>
    <auth-nav-component />
    <sign-up-component />
  </v-main>
</template>

<script>
import AuthNavComponent from "@/components/common/AuthNavComponent";
import SignUpComponent from "@/components/auth/SignUpComponent";

export default {
  components: {
    AuthNavComponent,
    SignUpComponent,
  },
  name: "SignUpView",
};
</script>

<style scoped></style>
