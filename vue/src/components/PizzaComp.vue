<template>
   <div>
      <h1>Le nostre pizze</h1>

      <ul>
         <li
            v-for="pizza in pizzas"
            :key="pizza.id"
         >
            <span v-if="editId != pizza.id">
               {{ pizza.name }}
               <input type="button" value="Modifica" @click="editPizza(pizza.id)"/>
            </span>
            <span v-else>
               <form @submit="updatePizza">
                  <input type="text" name="name" v-model="pizza.name" />
                  <input type="submit" value="Aggiorna" />
               </form>
            </span>
            <input type="button" value="Delete" />
         </li>
      </ul>
   </div>
 </template>
 
 <script>
import axios from 'axios';

const editId = -1;

 export default {
   name: 'PizzaComp',

   data() {
      return {
         apiUrl: 'http://localhost:8080/api/1/pizza',
         pizzas: [],

         editId : editId,
      }
   },

   methods: {

      getPizzaIndexById(id) {

         return this.pizzas.findIndex(pizza => pizza.id === id);
      },
      editPizza(id) {

         this.editId = id;
      },
      updatePizza(e) {

         e.preventDefault();

         const pizzaId = this.editId;
         const pizzaIndex = this.getPizzaIndexById(pizzaId);
         const pizza = this.pizzas[pizzaIndex];

         this.editPizza(editId);

         axios.post(this.apiUrl + "pizza/update/" + pizzaId, pizza)
            .then(result => {
               this.pizzas[pizzaIndex] = result.data;
            })
            .catch(error => {
               console.log(error);
            })
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
 