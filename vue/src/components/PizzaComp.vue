<template>
   <div>
      <h1>Le nostre pizze</h1>

      <ul>
         <li
            v-for="pizza in pizzas"
            :key="pizza.id"
         >
            {{ pizza.name }}
         </li>
      </ul>
   </div>
 </template>
 
 <script>
import axios from 'axios';

 export default {
   name: 'PizzaComp',

   data() {
      return {
         apiUrl: 'http://localhost:8080/api/1/pizza',
         pizzas: []
      }
   },

   mounted() {
      axios.get(this.apiUrl + "/all")
         .then(result => {

            console.log(result.data);
            this.pizzas = result.data;
         });
   }
 }
 </script>
 

 <style scoped lang="scss">

 </style>
 