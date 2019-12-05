
var stompClient = null;

function socketConnect() {

  // Create a socket and subscribe to a consumer mapping.
    
}

function sendSocketMessage() {
  
  // Send a message.
  
}

function socketDisconnect() {
  
  if (stompClient !== null) {
    
    $("#connect-button").prop('disabled', false); 
    
    stompClient.disconnect();
  }
  
}

function showData(value,content) {
  
  var origin;
  
  if(value != 0) {
     origin = "Java";
  } else {
     origin = "Website"; 
  }
  
  var childCount = $("#websocket-message tr").length;
  
  if(childCount > 5) {
  
     $('#websocket-message tr:first').remove();
     
  }
  
  $("#websocket-message").append("<tr><td>"+ origin +"</td><td>"+ content +"</td></tr>");
}

$(function () {

  $("#socket-connect").on('submit', function (e) {
    
    e.preventDefault();
    socketConnect();
    
  });
  
  $("#socket-disconnect").on('submit', function (e) {
    
    e.preventDefault();
    socketDisconnect();
    
  });

  $("#kafka-rest-form").on('submit', function (e) {
    
    e.preventDefault();
    
    $.ajax({
      method: 'GET',
      url: '/send/rest-data/',
      data: $('#kafka-rest-form').serialize()
    }).done(function(data, textStatus, jqXHR) {
      console.log("Success");
    }).fail(function(jqXHR, textStatus, errorThrown) {
      console.log("Failure");
    });
    
  });
  
  $("#kafka-socket-form").on('submit', function (e) {
  
    e.preventDefault();
    sendSocketMessage();
  
  });
  
});
