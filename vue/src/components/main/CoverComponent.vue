<template>
  <v-img
    src="~@/assets/cover.jpg"
    height="40vh"
    gradient="to top right, rgba(0,0,0,.5), rgba(0,0,0,.5)"
  >
    <v-container fill-height class="ma-2">
      <v-row align="center">
        <v-col sm="8">
          <v-flex class="white--text">
            <h2 class="mb-6">
              <div class="mb-2">직접 탐험하여 찾고<br /></div>
              <div>포인트를 얻어보세요.</div>
            </h2>
            <h4 class="mb-8">
              <div class="mb-2">쌓은 포인트로 다양한 <br /></div>
              <div class="mb-8">기프티콘, 상품권 등을 얻을 기회!</div>
            </h4>
            <v-btn
              depressed
              width="150"
              class="white--text text-decoration-none"
              color="orange"
              to="/travels/free"
              ><b>시작하기</b>
            </v-btn>
          </v-flex>
        </v-col>
      </v-row>
    </v-container>
  </v-img>
</template>

<script>
export default {
  name: "CoverComponent",
};
</script>

<style scoped></style>
