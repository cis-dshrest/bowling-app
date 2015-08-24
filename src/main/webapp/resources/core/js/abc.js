function calc(op, calcType) {

  if (throw_no == 1) {
    results[frame_no] = [];
  } 
  else if (throw_no == 2) {
    for (var j = 0; j < 10; j++) {
      eval("form['b-" + j + "'].disabled=false");
    }
    form['b-/'].disabled = false;
  }

  if (op == "1" || op == "2" || op == "3" || op == "4" || op == "5"
    || op == "6" || op == "7" || op == "8" || op == "9" || op == "0") {

    results[frame_no][throw_no] = parseInt(op);

    if (throw_no == 1) {
      eval("form['frame" + frame_no + "-1'].value = " + op);
      throw_no++;
      form['b-X'].disabled = true;
      form['b-/'].disabled = false;
      for (var k = parseInt(10 - op); k < 10; k++) {
        eval("form['b-" + k + "'].disabled=true");
      }
    } else if (throw_no == 2) {

      results[frame_no]['status'] = 'no';
      eval("form['frame" + frame_no + "-2'].value = " + op);

      if (frame_no != 10) {
        //alert("normal");
        calculate_frame_result(parseInt(results[frame_no][throw_no]
        + results[frame_no][throw_no - 1]));
        throw_no--;
        frame_no++;
        form['b-/'].disabled = true;
        form['b-X'].disabled = false;
      } else {
        if (results[frame_no]['1'] != 10) {
          calculate_frame_result(parseInt(parseInt(results[frame_no][throw_no])
              + parseInt(results[frame_no][throw_no - 1])));
          end_game();
        } else {
          throw_no++;
        }
      }
    } else {
      eval("form['frame" + frame_no + "-3'].value = " + op);

      calculate_frame_result(parseInt(parseInt(results[frame_no][throw_no])
          + parseInt(results[frame_no][throw_no - 1])
          + parseInt(results[frame_no][throw_no - 2])));
      if (frame_no == 10) {
        end_game();
      } else {
        throw_no = 1;
        frame_no++;
        for (var k = 1; k < 10; k++) {
          eval("form['b-" + k + "'].disabled=false");
          form['b-X'].disabled = false;
          form['b-/'].disabled = true;
        }
      }
    }
    return;
  }

  if (op == "X") {

    if (frame_no == 10) {

      results[frame_no][throw_no] = '10';

      switch (throw_no) {
      case 1 :
        eval("form['frame" + frame_no + "-1'].value = 'X'");
        break;
      case 2 :
        eval("form['frame" + frame_no + "-2'].value = 'X'");
        form['b-/'].disabled = true;
        break;
      case 3 :
        eval("form['frame" + frame_no + "-3'].value = 'X'");
        calculate_frame_result(parseInt(parseInt(results[frame_no]['1'])
            + parseInt(results[frame_no]['2'])
            + parseInt(results[frame_no]['3'])));
        end_game();
        break;
      }
      throw_no++;
    } else {
      results[frame_no]['status'] = 'X';
      results[frame_no][throw_no] = '10';
      results[frame_no][throw_no + 1] = '';
      calculate_frame_result(parseInt(10));
      eval("form['frame" + frame_no + "-1'].value = ''");
      eval("form['frame" + frame_no + "-2'].value = 'X'");

      frame_no++;
      form['b-/'].disabled = true;
    }

    return;
  }

  if (op == "/") {

    if (frame_no == 10) {

      results[frame_no][throw_no] = parseInt(10 - parseInt(results[frame_no][throw_no - 1]));

      switch (throw_no) {
      case 2 :
        eval("form['frame" + frame_no + "-2'].value = '/'");
        form['b-X'].disabled = false;
        form['b-/'].disabled = true;
        throw_no++;
        break;
      case 3 :
        eval("form['frame" + frame_no + "-3'].value = '/'");
        calculate_frame_result(parseInt(parseInt(results[frame_no]['1'])
            + parseInt(results[frame_no]['2'])
            + parseInt(results[frame_no]['3'])));
        end_game();
        break;
      }
    } else {
      results[frame_no]['status'] = '/';
      results[frame_no][throw_no] = parseInt(10 - results[frame_no][throw_no - 1]);
      calculate_frame_result(parseInt(10));
      eval("form['frame" + frame_no + "-2'].value = '/'");

      frame_no++;
      throw_no--;
      form['b-X'].disabled = false;
      form['b-/'].disabled = true;
    }

    return;
  }

  if (op == "new") {
    for (var i = 1; i <= 10; i++) {
      eval("form['frame" + i + "-1'].value = ''");
      eval("form['frame" + i + "-2'].value = ''");
      if (calcType == "duckpin") {
        eval("form['frame" + i + "-3'].value = ''");
      }
      eval("form['frame" + i + "-res'].value = ''");
      results.length = 0;
    }
    eval("form['frame10-3'].value = ''");
    form['game_result'].value = '';
    frame_no = 1;
    throw_no = 1;
    for (var j = 0; j < 10; j++) {
      eval("form['b-" + j + "'].disabled=false");
    }
    form['b-X'].disabled = false;
    form['b-/'].disabled = true;

  }
}