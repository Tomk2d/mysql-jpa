//updateMind.js
function updateMind(companies) {
    var selectedCompany = document.getElementById('company').value;

    // 선택된 회사의 인재상 찾기
    var selectedCompanyTalents = companies.find(company => company.c_id.toString() === selectedCompany);

    // 인재상 셀렉트 박스 업데이트
    if (selectedCompanyTalents) {
        var talentsSelect = document.getElementById('talent');
        talentsSelect.innerHTML = '';
        for (var i = 1; i <= 4; i++) {
            var option = document.createElement('option');
            option.value = selectedCompanyTalents['c_mind' + i];
            option.text = selectedCompanyTalents['c_mind' + i];
            talentsSelect.appendChild(option);
        }
    }
}

document.addEventListener('DOMContentLoaded', function() {
    var companySelect = document.getElementById('company');
    if (companySelect) {
        companySelect.addEventListener('change', function() {
            updateTalents(allCompanies);
        });
    }
});
