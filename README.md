# PDF 생성 프로그램

템플릿 엔진으로 렌더링된 html 을 PDF 컨버터로 이용하여 PDF 를 만든다.

## 이슈
- 한글을 출력하기 위해 한글폰트가 필요함. 나눔고딕 사용
- 외부 스타일시트를 사용할 수 없어 내부에 스타일시트 작성
- 페이지 가로 세로 변경가능. 템플릿에 데이터를 설정해주면 된다. `width = true or false` css 도 같이 참고한다.
- 페이지 분리 가능. `.page-break` css 클래스 사용

## 지원 템플릿

- FreeMarker : https://freemarker.apache.org/
- Handlebars.java : https://github.com/jknack/handlebars.java

## 참고한 정보

- https://github.com/xiang-lee/pdf-generator
- https://github.com/andreldm/flying-saucer-handlebars-example
