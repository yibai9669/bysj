<template>
  <div class="yin-footer">
    <p>软升本2021级刘海阳毕业设计</p>
    <p class="youqinhlianjie">友情链接：
      <a  href="https://music.163.com/">网易云音乐</a>
      <span style="color:#6CA6CD;">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
      <a  href="https://y.qq.com/">QQ音乐</a>
      <span style="color:#6CA6CD;">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
      <a  href="https://www.kugou.com/">酷狗音乐</a>
    </p>
  </div>
</template>

<script lang="ts">


</script>

<style lang="scss" scoped>
@import "@/assets/css/var.scss";
@import "@/assets/css/global.scss";

.yin-footer {
  width: 100%;
  height: $footer-height;
  padding: 20px 0;
  box-sizing: border-box;
  font-size: 14px;
  color: #6CA6CD;
  @include layout(center, center, column);
  a {
    text-decoration: none;
  }
  a:link{color: #6CA6CD;}
  a:visited{color: #6CA6CD;}
  a:hover{color: #6CA6CD;}
  a:active{color: #6CA6CD;}
}

p {
  height: 30px;
}
</style>
