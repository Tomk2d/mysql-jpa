function addCard() {
    // 새로운 링크 요소 생성
    var newLink = document.createElement('a');
    newLink.href = 'new_url.html'; // 새 카드의 URL 설정
    newLink.className = 'card-link';

    // 새로운 카드 요소 생성
    var newCard = document.createElement('div');
    newCard.className = 'card';

    // 새로운 카드 내용 설정
    var cardTitle = document.createElement('h2');
    cardTitle.textContent = '새로운 자기소개서';
    var cardDescription = document.createElement('p');
    cardDescription.textContent = '자기소개서를 작성해보세요!';

    // 카드 요소에 제목과 설명 추가
    newCard.appendChild(cardTitle);
    newCard.appendChild(cardDescription);

    // 링크 요소에 카드 추가
    newLink.appendChild(newCard);

    // 카드 컨테이너에 새 링크(카드) 추가
    document.getElementById('cardContainer').appendChild(newLink);
}
