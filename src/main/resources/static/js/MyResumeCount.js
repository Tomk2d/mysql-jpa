function addResumeForm() {
    // 이전에 제공된 코드
}

function countCharacters() {
    var resumeText = document.getElementById('resume').value;
    var characterCount = resumeText.length;
    document.getElementById('characterCount').innerText = '글자수: ' + characterCount;
}
