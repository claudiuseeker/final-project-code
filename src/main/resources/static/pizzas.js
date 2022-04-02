$(document).ready(() => {
     let pizzaToEdit;

         $('#add-button-modal').click(() => {
             const name = $('#modal-name').val();
             const size = $('#modal-size').val();
             const toppings = $('#modal-toppings').val();

             toppingsList = toppings.split(',');

             const newPizza = {
                 name: name,
                 size: size,
                 toppings: toppingsList
             };

             if (pizzaToEdit == null) {
                 addPizza(newPizza);
             } else {
                 editPizza(pizzaToEdit, newPizza)
             }
         });

         function editPizza(id, newPizza) {
             fetch('api/pizzas/' + id, {
                 method: 'PUT',
                 body: JSON.stringify(newPizza),
                 headers: {
                     'Content-Type': 'application/json'
                 }
             }).then(response => {
                 if (response.ok) {
                     location.reload();
                 } else {
                     alert("There are errors " + response.status);
                 }
             });
         }

         function addPizza(newPizza) {
             fetch('api/pizzas', {
                 method: 'POST',
                 body: JSON.stringify(newPizza),
                 headers: {
                     'Content-Type': 'application/json'
                 }
             }).then(response => {
                 if (response.ok) {
                     location.reload();
                 } else {
                     alert("There are errors " + response.status);
                 }
             });
         }

         $('.edit-icon').click(function () {

             pizzaToEdit = this.parentElement.id;

             const row = this.parentElement.parentElement;

             const name = row.children[0].innerText;
             const size = row.children[1].innerText;
             const toppings = row.children[2].innerText;

             $('#modal-name').val(name);
             $('#modal-size').val(size);
             $('#modal-toppings').val(toppings);
         });
         $('.delete-icon').click(function () {
                const pizzaId = this.parentElement.id;

                fetch('api/pizzas/' + pizzaId, {
                    method: 'DELETE'
                }).then(response => location.reload());
            });

     $('#add-pizza-button').click(function () {
             pizzaToEdit = null;
             clearModal();
         });

     function clearModal() {
              $('#modal-name').val('');
              $('#modal-size').val('');
              $('#modal-toppings').val('');
     }
});