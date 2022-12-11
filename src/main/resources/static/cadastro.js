(function() {
    var caixa = document.getElementById("alergiaCheck");
    caixa.style.display = "none";

    $("#radiodiv input:radio").click(function() {
        if ($("#sim").is(":checked")) {
            caixa.style.display = "block";
    
        } else if ($("#nao").is(":checked")) {
            caixa.style.display = "none";
        }
    });

    $("#tabusuario").on("click", ".js-delete", function() {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalusuario").modal("show");
    });

    $("#btnsim").on("click", function() {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/cadastro/delete/" + id,
            method: "GET",
            success: function() {
                window.location.href="/cadastro";
            }
        })
    });
})();