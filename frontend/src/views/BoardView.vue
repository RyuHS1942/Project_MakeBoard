<script setup lang="ts">
import axios from "axios";
import {onMounted, ref} from "vue";
import {RouterLink} from "vue-router";

let boardList = ref<Array<any>[]>([]);

//onMounted(async () => {
  axios.get('http://localhost:8080/board')
      .then(response => {
        boardList = response.data;
        //console.log(response.data);
      })
      .catch(error => {
        console.log('Error fetching data: ', error);
      });
//})

</script>

<template>
  <div class="button">
    <button><RouterLink to="/post">등록하기</RouterLink></button>
  </div>

  <div class="table">
    <table style="width: 500px;">
      <colgroup>
        <col style="width: 10%;">
        <col style="width: 50%;">
        <col style="width: 15%;">
        <col style="width: 25%;">
      </colgroup>
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">title</th>
          <th scope="col">createdBy</th>
          <th scope="col">createdAt</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="postList in boardList">
          <td style="text-align: center" >{{ postList.postId }}</td>
          <td style="text-align: left" >
            <RouterLink :to="{ name: 'post-read', params: { id: postList.postId } }">{{ postList.postTitle }}</RouterLink>
          </td>
          <td style="text-align: center" >{{ postList.createdBy }}</td>
          <td style="text-align: center" >{{ postList.createdAt }}</td>
        </tr>
      </tbody>
    </table>
  </div>

  <div class="page">

  </div>

</template>

<style scoped>
@media (min-width: 1024px) {
  .board {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>