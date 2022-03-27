$(document).ready(() => {
      $('#add-button-modal').click(() => {
            console.log("am intrat");
            const name = $('#modal-name').val();
            const size = $('#modal-size').val();
            const toppings = $('#modal-toppings').val();

            const newPizza = {
                name: name,
                size: size,
                toppings: [toppings]
            };

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

        });
         $('.delete-icon').click(function () {
                const pizzaId = this.parentElement.id;

                fetch('api/pizzas/' + pizzaId, {
                    method: 'DELETE'
                }).then(response => location.reload());
            });
});