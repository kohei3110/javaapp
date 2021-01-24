$(function() {
    var url = 'ws://localhost:8080/websocket/echows';
    var ws = new WebSocket(url);
    
    ws.onmessage = function(receive){
        $('message').text(receive.data);
    };
    
    ws.onopen = function(){
        ws.send('Hello WebSocket');
    };
});

