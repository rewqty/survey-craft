window.onload = function() {

    $(".addButtonQuestion").click((e) => {

        console.log($(".question")['0']);
        var cloneQuestion = $(".question").clone()['0'];
        $(cloneQuestion).find('.question-title-str').val('');
        $(cloneQuestion).find('.answer-button').not(':first-child').remove();
        $(cloneQuestion).find('.answer').val('');
        $(cloneQuestion).find('.deleteAnswer').prop('disabled', true);
        $('.survey').append(cloneQuestion);
        console.log("debug: button text: " + e.currentTarget.innerText);
    });


    $('body').on('click', '.addButtonAnswer', function (e) {
        console.log($(this));
        console.log($(this).parent());
        console.log($(this).parent().parent());
        var question = $(this).parent().parent();
        console.log(question.find('.answer-button')['0']);
        var answer = question.find('.answer-button')['0'];
        $(question.find('.answer-button')['0']).find('.deleteAnswer').prop('disabled', false);
        question.find('.answers').append($(answer).clone().val(''));
    });

    $('body').on('click', '.addSurvey', function (e) {
        console.log($(this).parent().parent().find('.survey').children());
        var survey = {};
        var questions = [];
        $(this).parent().parent().find('.survey').children().each(function (index) {
            var question = {};
            console.log($(this));
            var typeQuestion = $(this).find('.select-type').val();
            var questionTitle = $(this).find('.question-title-str').val();
            var answers = []
            $(this).find('.answer').each(function (index) {
                answers.push($(this).val());
            });
            question.typeQuestion = typeQuestion;
            question.question = questionTitle;
            question.answers = answers;
            questions.push(question);
            console.log(questions);
        })
        survey.id = null;
        survey.title = $(this).parent().parent().children().find('.title').val();
        survey.questions = questions;
        console.log(survey);

        $.ajax("/new",
        {
          type: "POST",
          data: JSON.stringify(survey),
          contentType: "application/json",
          dataType: "json",
        }).always(function(data) {
            window.location.replace("/")
        });
    });

    $('body').on('click', '.deleteAnswer', function (e) {
        console.log($(this));
        console.log($(this).parent());
        var answerWithButton = $(this).parent();
        console.log(answerWithButton.find('.answer'));
        var answers = answerWithButton.parent();
        answerWithButton.remove();
        console.log(answers.children().length == 1);
        if (answers.children().length == 1) {
            $(answers.find('.answer-button')['0']).find('.deleteAnswer').prop('disabled', true);
        }
    });
};