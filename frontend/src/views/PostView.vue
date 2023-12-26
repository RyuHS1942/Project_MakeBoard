<script lang="ts" setup>
import {RouterLink, useRoute} from "vue-router";
import axios from "axios";
import {onMounted, ref} from "vue";

const route = useRoute();
const id = route.params.id;
let postInfo = ref<Array<any>[]>([]);

let title = ref<String>('');
let content = ref<String>('');
let createdBy = ref<String>('');
let createdAt = ref<String>('');

onMounted(async () => {
  axios.post('http://localhost:8080/board/info', { postId: id })
      .then(response => {
        postInfo = response.data;
        //console.log(response.data);
        title = postInfo.postTitle;
        content = postInfo.postContent;
        createdBy = postInfo.createdBy;
        createdAt = postInfo.createdAt;
      })
      .catch(error => {
        console.log('Error fetching data: ', error);
      });
})

function fnCreatePost(title:string, content:string) {
  axios.post('http://localhost:8080/board/create', {
    postId: '3'
    , postTitle: title
    , postContent: content
  })
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.log('Error fetching data: ', error);
      });
}

function fnUpdatePost() {
  axios.post('http://localhost:8080/board/update', {
    postId: id
    , postTitle: title
    , postContent: content
  })
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.log('Error fetching data: ', error);
      });
}

function fnDeletePost() {
  axios.post('http://localhost:8080/board/delete', {
    postId: id
  })
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.log('Error fetching data: ', error);
      });
}

</script>

<template>

  <div class="table">
    <table style="width: 500px;">
      <colgroup>
        <col style="width: 10%;">
        <col style="width: auto;">
        <col style="width: 10%;">
        <col style="width: 50%;">
      </colgroup>
      <tbody>
      <tr>
        <th>제목</th>
        <td>
          <input v-model="title" type="text">
        </td>
        <th>{{ createdBy }}</th>
        <th>{{ createdAt }}</th>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="3" style="text-align: center; width: 100%">
          <input v-model="content" style="width: 100%" type="text">
        </td>
      </tr>
      </tbody>
    </table>
  </div>

  <div class="button">
    <button>
      <RouterLink to="/board">목록</RouterLink>
    </button>
    <button v-if="id" @click="fnUpdatePost">
      <RouterLink to="/board">수정</RouterLink>
    </button>
    <button v-else @click="fnCreatePost(title, content)">
      <RouterLink to="/board">등록</RouterLink>
    </button>
    <button @click="fnDeletePost">
      <RouterLink to="/board">삭제</RouterLink>
    </button>
  </div>

</template>

<style scoped>

</style>