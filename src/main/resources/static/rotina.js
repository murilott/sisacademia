$(".rotina").on("click", function() {
    // alert('Funciona');
    let botaoRotina = $(this);
    let id = botaoRotina.attr("id");
    let user_id = botaoRotina.attr("user-id");
    console.log(id);

    $.ajax({
        url: "/rotina/" + user_id + "/escolher/" + id,
        method: "GET",
        success: function() {
            window.location.href="/rotina/" + user_id + "/escolher/" + id;
        }
    })
});