<template>
  <v-main>
    <auth-nav-component />
    <login-component />
  </v-main>
</template>

<script>
import LoginComponent from "@/components/auth/LoginComponent";
import AuthNavComponent from "@/components/common/AuthNavComponent";

export default {
  components: {
    AuthNavComponent,
    LoginComponent,
  },
  name: "LoginView",
};
</script>

<style scoped></style>
