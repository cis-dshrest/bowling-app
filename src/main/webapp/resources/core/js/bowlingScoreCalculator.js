/**
 * bowlingScoreCalculator.js
 * 
 * Calculate scores for a bowling game with 10 frames.
 * A game can have multiple users.
 * Eventually the score will be stored in the database.
 * 
 * @since 08/19/2015
 * 
 */


//global vars initialization
var frame_no = [];
var throw_no = [];
var results = [[]];//new Array();

/**
 * Ask user for confirmation before closing the page.
 */
var formSubmitting = false;
var setFormSubmitting = function() {
  formSubmitting = true;
};

window.onload = function() {
  
  //initialize variables.
  initVars();
  
  window.addEventListener("beforeunload", function(e) {
    var confirmationMessage = 'If you leave before completing the game, your scores will not be saved.';

    if (formSubmitting) {
      return document.location = "/Exploration/user/game/new";
    }

    (e || window.event).returnValue = confirmationMessage; //Gecko + IE
    return confirmationMessage; //Gecko + Webkit, Safari, Chrome 
  });
};



/**
 * Get query arguments with QueryString.var
 */
var QueryString = function () {
  // This function is anonymous, is executed immediately and 
  // the return value is assigned to QueryString!
  var query_string = {};
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
        // If first entry with this name
    if (typeof query_string[pair[0]] === "undefined") {
      query_string[pair[0]] = decodeURIComponent(pair[1]);
        // If second entry with this name
    } else if (typeof query_string[pair[0]] === "string") {
      var arr = [ query_string[pair[0]],decodeURIComponent(pair[1]) ];
      query_string[pair[0]] = arr;
        // If third or later entry with this name
    } else {
      query_string[pair[0]].push(decodeURIComponent(pair[1]));
    }
  } 
    return query_string;
}();





/**
 * Initialize frame number and throw number for all players.
 */
var initVars = function () {
  

  
  
  var playerHTMLObjs = $("p.user-info");
  var re = /\(([^)]+)\)/;
  for(var i = 0; i < playerHTMLObjs.length; i++) {
    var playerUsername = playerHTMLObjs[i].innerHTML;
    playerUsername = (re.exec(playerUsername))[1];
    frame_no[playerUsername] = 1;
    throw_no[playerUsername] = 1;
    
    console.log("initplayer:"+playerUsername);
    console.log("frame_no[playerUsername]:"+ frame_no[playerUsername]);
  }
}


/**
 * Calculates results.
 */
function calc(op, player) {
  
  console.log("player:" + player);
  
  //Set button,frame controls for the specific player
  var buttonObjs = $("#bowling-calc-buttons-container-" + player);
  var frameObjs = $("#bowling-calc-container-"+player+" .bowling-calc-score-table");
  
//  Make user finish a complete frame before letting other user go
//  if(throw_no[player] < 2 ) {
//    disable_other_players(player);
//  }
//  else {
//    enable_players();
//  }
  
  // First throw, reset results.
  if (throw_no[player] == 1) {
    results[frame_no[player]] = [];
    console.log("results: " + results[frame_no[player]]);
    
    
  } 
  
  //second throw, enable spare
  else if (throw_no[player] == 2) {
    for (var j = 0; j < 10; j++) {
      buttonObjs.find("input[name='b-"+ j +"']").attr("disabled", false);
    }
    buttonObjs.find("input[name='b-/']").attr("disabled", false);
  }
  
  if (op == "1" || op == "2" || op == "3" || op == "4" || op == "5"
    || op == "6" || op == "7" || op == "8" || op == "9" || op == "0") {

    console.log("frameno:" + frame_no[player] + " throwno:" + throw_no[player]);
    results[frame_no[player]][throw_no[player]] = parseInt(op);
    
    console.log("results after op: " + results[frame_no[player]][throw_no[player]]);
    
    if ( throw_no[player] == 1) {
      console.log("throw was 1");
      frameObjs.find("#edit-frame"+ frame_no[player] + "-1").val(op);
      throw_no[player]++;
      buttonObjs.find("input[name='b-X']").attr("disabled", true);
      buttonObjs.find("input[name='b-/']").attr("disabled", false);
      for (var k = parseInt(10 - op); k < 10; k++) {
        buttonObjs.find("input[name='b-"+k+"']").attr("disabled", true);
      }
    }
    
    else if (throw_no[player] == 2) {
      
      results[frame_no[player]]['status'] = 'no';
      frameObjs.find("#edit-frame"+ frame_no[player] + "-2").val(op);
    
      if (frame_no[player] != 10) {
        calculate_frame_result(player, parseInt(results[frame_no[player]][throw_no[player]]
        + results[frame_no[player]][throw_no[player] - 1]));
        throw_no[player]--;
        frame_no[player]++;
        buttonObjs.find("input[name='b-/']").attr("disabled", true);
        buttonObjs.find("input[name='b-X']").attr("disabled", false);
      }
      
      else {
        if (results[frame_no[player]]['1'] != 10 ) {
          calculate_frame_result(player, parseInt(parseInt(results[frame_no[player]][throw_no[player]])
              + parseInt(results[frame_no[player]][throw_no[player] - 1])));
          
          end_game();
        }
        else {
          throw_no[player]++;
        }
      }
    }
    
    else {
      frameObjs.find("#edit-frame" + frame_no[player] + "-3").val(op);
      
      calculate_frame_result(player, parseInt(parseInt(results[frame_no[player]][throw_no[player]])
          + parseInt(results[frame_no[player]][throw_no[player] - 1])
          + parseInt(results[frame_no[player]][throw_no[player] - 2])));
      
      if (frame_no[player] == 10) {
        end_game(player);
      }
      else {
        throw_no[player] = 1;
        frame_no[player]++;
        for (var i = 1; i < 10; i++) {
          buttonObjs.find("input[name='b-"+ i +"']").attr("disabled", false);
        }
        buttonObjs.find("input[name='b-X']").attr("disabled", false);
        buttonObjs.find("input[name='b-/']").attr("disabled", true); 
      }
    }
    return;
  }
  
  if (op == "X") {
    
    if (frame_no[player] == 10) {
      results[frame_no[player]][throw_no[player]] = '10';
      
      switch(throw_no[player]) {
      case 1 :
        frameObjs.find("#edit-frame" + frame_no[player] + "-1").val('X');
        break;
      case 2 :
        frameObjs.find("#edit-frame" + frame_no[player] + "-2").val('X');
        buttonObjs.find("input[name='b-/']").attr("disabled", true);
        break;
      case 3 :
        frameObjs.find("#edit-frame" + frame_no[player] + "-3").val('X');
        calculate_frame_result(player, parseInt(parseInt(results[frame_no[player]]['1'])
            + parseInt(results[frame_no[player]]['2'])
            + parseInt(results[frame_no[player]]['3'])));
        end_game(player);
        break;
      }
      throw_no[player]++;
    }
    else {
      results[frame_no[player]]['status'] = 'X';
      results[frame_no[player]][throw_no[player]] = '10';
      results[frame_no[player]][throw_no[player] + 1] = '';
      calculate_frame_result(player, parseInt(10));
      frameObjs.find("#edit-frame" + frame_no[player] + "-1").val('');
      frameObjs.find("#edit-frame" + frame_no[player] + "-2").val('X');
      
      frame_no[player]++;
      buttonObjs.find("input[name='b-/']").attr("disabled", true);
      
    }

    return;
  }
  
  if (op == "/") {
    
    if (frame_no[player] == 10 ) {
      results[frame_no[player]][throw_no[player]] = parseInt(10 - parseInt(results[frame_no[player]][throw_no[player] - 1]));
      
      switch(throw_no[player]) {
      case 2 :
        frameObjs.find("#edit-frame" + frame_no[player] + "-2").val("/");
        buttonObjs.find("input[name='b-X']").attr("disabled", false);
        buttonObjs.find("input[name='b-/']").attr("disabled", true);
        throw_no[player]++;
        break;
      case 3 :
        frameObjs.find("#edit-frame" + frame_no[player] + "-3").val("/");
        calculate_frame_result(player, parseInt(parseInt(results[frame_no[player]]['1'])
            + parseInt(results[frame_no[player]]['2'])
            + parseInt(results[frame_no[player]]['3'])));
        end_game(player);
        break;
      }
    }
    
    else {
      results[frame_no[player]]['status'] = '/';
      results[frame_no[player]][throw_no[player]] = parseInt(10 - results[frame_no[player]][throw_no[player] - 1]);
      calculate_frame_result(player, parseInt(10));
      frameObjs.find("#edit-frame" + frame_no[player] + "-2").val("/");
      
      frame_no[player]++;
      throw_no[player]--;
      buttonObjs.find("input[name='b-X']").attr("disabled", false);
      buttonObjs.find("input[name='b-/']").attr("disabled", true);
    }
    
    return;
  }
}

function calculate_frame_result(player, frame_res) {
  
  console.log("frame_no calculate: " + frame_no[player]);
  console.log("frame_no result: " + frame_res);
  
  switch (frame_no[player]) {
  case 1 :
    results[frame_no[player]]['result'] = frame_res;
    break;
  case 2 :
    if (results[frame_no[player] - 1]['status'] == 'X') {
      results[frame_no[player] - 1]['result'] = parseInt(results[frame_no[player] - 1]['result'])
      + frame_res;
    } else if (results[frame_no[player] - 1]['status'] == '/') {
      results[frame_no[player] - 1]['result'] = parseInt(results[frame_no[player] - 1]['result'])
      + parseInt(results[frame_no[player]]['1']);
    }
    results[frame_no[player]]['result'] = parseInt(results[frame_no[player] - 1]['result']
    + frame_res);
    break;
  default :
    if (results[frame_no[player] - 1]['status'] == 'X') {
      if (results[frame_no[player] - 2]['status'] == 'X') {
        results[frame_no[player] - 2]['result'] = parseInt(results[frame_no[player] - 2]['result'])
        + parseInt(results[frame_no[player]]['1']);
        results[frame_no[player] - 1]['result'] = parseInt(results[frame_no[player] - 1]['result'])
        + parseInt(results[frame_no[player]]['1']);
      }
      results[frame_no[player] - 1]['result'] = parseInt(results[frame_no[player] - 1]['result'])
      + parseInt(results[frame_no[player]]['1'])
      + (results[frame_no[player]]['2'] == ''
        ? parseInt(0)
            : parseInt(results[frame_no[player]]['2']));
    } else if (results[frame_no[player] - 1]['status'] == '/') {
      results[frame_no[player] - 1]['result'] = parseInt(results[frame_no[player] - 1]['result'])
      + parseInt(results[frame_no[player]]['1']);
    }
  results[frame_no[player]]['result'] = parseInt(results[frame_no[player] - 1]['result']
  + frame_res);
  break;
  }
  update_frame_result(player);
  return;
}

function update_frame_result(player) {

  var buttonObjs = $("#bowling-calc-buttons-container-" + player);
  var frameObjs = $("#bowling-calc-container-"+player+" .bowling-calc-score-table");
  
  switch (frame_no[player]) {
  case 1 :
    frameObjs.find("input[name='frame" + frame_no[player] + "-res']")
      .val(results[frame_no[player]]['result']);
    break;
  case 2 :
    frameObjs.find("input[name='frame" + parseInt(frame_no[player] -1) + "-res']")
    .val(results[frame_no[player] - 1]['result']);
    
    frameObjs.find("input[name='frame" + frame_no[player] + "-res']")
    .val(results[frame_no[player]]['result']);
    break;
  default :
    frameObjs.find("input[name='frame" + parseInt(frame_no[player] - 2) + "-res']")
    .val(results[frame_no[player] - 2]['result']);
  
    frameObjs.find("input[name='frame" + parseInt(frame_no[player] - 1) + "-res']")
    .val(results[frame_no[player] - 1]['result']);
    
    frameObjs.find("input[name='frame" + frame_no[player] + "-res']")
    .val(results[frame_no[player]]['result']);
  break;
  }
  frameObjs.find("input[name='game_result']").val(results[frame_no[player]]['result']);
  return;
}

function end_game(player) {
  
  var buttonObjs = $("#bowling-calc-buttons-container-" + player);
  
  for (var i = 0; i < 10; i++) {
    buttonObjs.find("input[name='b-"+i+"']").attr("disabled", true);
  }
  
  buttonObjs.find("input[name='b-X']").attr("disabled", true);
  buttonObjs.find("input[name='b-/']").attr("disabled", true);

}

function disable_other_players(player) {

  
  var usernames = get_usernames();
  
  for (var i = 0; i < usernames.length; i++) {
    if (usernames[i] !== player) {
      var buttonObjs = $("#bowling-calc-buttons-container-" + usernames[i]);
      for (var j = 0; j < 10; j++) {
        buttonObjs.find("input[name='b-"+j+"']").attr("disabled", true);
      }
      buttonObjs.find("input[name='b-X']").attr("disabled", true);
      buttonObjs.find("input[name='b-/']").attr("disabled", true);
 
    }
  }
}

function enable_players() {
  var usernames = get_usernames();
    
  for (var i = 0; i < usernames.length; i++) {
    var buttonObjs = $("#bowling-calc-buttons-container-" + usernames[i]);
    for (var j = 0; j < 10; j++) {
      
      if (finished[usernames[i]] == false) {
        buttonObjs.find("input[name='b-"+j+"']").attr("disabled", false);
      }
      
    }
    buttonObjs.find("input[name='b-X']").attr("disabled", false);
    buttonObjs.find("input[name='b-/']").attr("disabled", true);
  }
}

function get_usernames() {

  var usernames = [];
  
  var playerHTMLObjs = $("p.user-info");
  var re = /\(([^)]+)\)/;
  
  for(var i = 0; i < playerHTMLObjs.length; i++) {
    var playerUsername = playerHTMLObjs[i].innerHTML;
    playerUsername = (re.exec(playerUsername))[1];
    usernames.push(playerUsername);
  }
  
  return usernames;
}

function reset_game() {
  initVars();
  
  var usernames = get_usernames();
  for( var i = 0; i < usernames.length; i++) {
    frame_no[usernames[i]] = 1;
    throw_no[usernames[i]] = 1;
    
    var buttonObjs = $("#bowling-calc-buttons-container-" + usernames[i]);
    var frameObjs = $("#bowling-calc-container-"+usernames[i]+" .bowling-calc-score-table");
    
    for(var j = 1; j <= 10; j++) {
      //throws 
      frameObjs.find("#edit-frame" + j + "-1").val('0');
      frameObjs.find("#edit-frame" + j + "-2").val('0');
      frameObjs.find("#edit-frame" + j + "-3").val('0');
      
      //results
      frameObjs.find("input[name='frame" + j + "-res']").val('0');
      
      //buttons
      buttonObjs.find("input[name='b-" + (j-1) + "']").attr("disabled", false);
    }
    
    frameObjs.find("input[name='game_result']").val('0');    
    frameObjs.find("#edit-frames10-3").val('');
    buttonObjs.find("input[name='b-X']").attr("disabled", false);
    buttonObjs.find("input[name='b-/']").attr("disabled", true);
    results.length = 0;
  }
  
}