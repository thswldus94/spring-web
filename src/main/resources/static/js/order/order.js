function add_order() {
    var orderList = [];

    $('input:checkbox[name="food_list"]:checked').each(function() {
        console.log(this.value);
        orderList.push({
            'storeIdx': $('input[name="store_idx"]').val(),
            'foodIdx': this.value
        });
    });

    // for (var i = 0; i <

    console.log(444);
    console.log(orderList);

    $.ajax({
        url: '/order/add_order',
        type: 'POST',
        data: JSON.stringify(orderList),
        dataType: 'json',
        contentType: 'application/json; UTF-8;'
    });

}