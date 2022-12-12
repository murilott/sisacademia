$(".dieta").on("click", function() {
    // alert('Funciona');
    let botaoDieta = $(this);
    let id = botaoDieta.attr("id");
    let user_id = botaoDieta.attr("user-id");
    console.log(id);

    $.ajax({
        url: "/dieta/" + user_id + "/escolher/" + id,
        method: "GET",
        success: function() {
            window.location.href="/dieta/" + user_id + "/escolher/" + id;
        }
    })
});