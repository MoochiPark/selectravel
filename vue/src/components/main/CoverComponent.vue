<template>
  <!--        <div class="main-text">-->
  <!--          <h2>-->
  <!--            <span><b>직접 탐험하여 찾고</b><br /></span>-->
  <!--            <span><b>포인트를 얻어보세요.</b></span>-->
  <!--          </h2>-->
  <!--          <h4>-->
  <!--            <span><b>쌓은 포인트로 다양한 </b><br /></span>-->
  <!--            <span><b>기프티콘, 상품권 등을 얻을 기회!</b></span>-->
  <!--          </h4>-->
  <!--          <a href="http://localhost:3000/travel" class="start-btn"-->
  <!--            ><span>시작하기</span></a-->
  <!--          >-->
  <!--        </div>-->
  <v-img
    src="~@/assets/cover.jpg"
    height="40vh"
    gradient="to top right, rgba(0,0,0,.5), rgba(0,0,0,.5)"
  >
    <v-container fill-height class="ma-2">
      <v-row align="center">
        <v-col sm="8">
          <div class="white--text">
            <h2 class="mb-6">
              <span>직접 탐험하여 찾고<br /></span>
              <span>포인트를 얻어보세요.</span>
            </h2>
            <h4 class="mb-8">
              <span>쌓은 포인트로 다양한 <br /></span>
              <span>기프티콘, 상품권 등을 얻을 기회!</span>
            </h4>
            <v-btn
              depressed
              width="150"
              class="white--text"
              color="orange"
              to="/travel"
              ><b>시작하기</b>
            </v-btn>
          </div>
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
