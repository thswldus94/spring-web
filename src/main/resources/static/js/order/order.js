function add_order() {
    var storeIdx = Number($('input[name="store_idx"]').val());

    var orderList = {
        'storeIdx' : storeIdx,
        'foodIdxList' : []
    };

    $('input:checkbox[name="food_list"]:checked').each(function() {
        console.log(this.value);
        orderList['foodIdxList'].push(Number(this.value));
    });

    console.log(orderList);

    $.ajax({
        url: '/order/add_order',
        type: 'POST',
        data: JSON.stringify(orderList),
        dataType: 'json',
        contentType: 'application/json; UTF-8;'
    }).done(function(data) {
        console.log(data);
        var orderIdx = data["orderIdx"];
        location.href = "/pay/confirm?orderIdx=" + orderIdx;
    });

}