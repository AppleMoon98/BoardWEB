/*
 * package com.mysite.sbb;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import java.beans.Transient; import java.time.LocalDateTime; import
 * java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.mysite.sbb.answer.Answer; import
 * com.mysite.sbb.answer.AnswerRepository; import
 * com.mysite.sbb.question.Question; import
 * com.mysite.sbb.question.QuestionRepository;
 * 
 * 
 * 
 * @SpringBootTest class BoardWebApplicationTests {
 * 
 * @Autowired private QuestionRepository questionRepository;
 * 
 * @Autowired private AnswerRepository answerRepository;
 * 
 * @Test
 * 
 * @Transactional void contextLoads() {
 * 
 * // Question q1 = new Question(); // q1.setSubject("sbb는 무엇인가요?"); //
 * q1.setContent("sbb에 대해서 알고 싶습니다"); // q1.setCreateDate(LocalDateTime.now());
 * // // this.questionRepository.save(q1); //
 * 
 * Question q2 = new Question(); q2.setSubject("스프링 부트 모델 질문");
 * q2.setContent("내용 수정"); q2.setCreateDate(LocalDateTime.now());
 * 
 * this.questionRepository.save(q2);
 * 
 * 
 * // 검색 select 쿼리문을 실행하는 메소드 // findAll() 전체검색 select * from Question
 * 
 * // // List<Question> all = this.questionRepository.findAll(); //
 * assertEquals(2, all.size()); // System.out.println(all.size()); // //
 * Question q = all.get(0); // System.out.println(q.getSubject()); //
 * System.out.println(q.getContent()); // System.out.println(q.getCreateDate());
 * 
 * // Optional<Question> oq = this.questionRepository.findById(1); // //
 * Question q = oq.get(); // System.out.println(q.getSubject()); //
 * System.out.println(q.getContent()); // System.out.println(q.getCreateDate());
 * // // // if(oq.isPresent()) { // Question q1 = oq.get(); //
 * assertEquals("sbb는 무엇인가요?", q1.getSubject()); // } // // // Question q2 =
 * oq.get(); // assertEquals("sbb는 무엇인가요?", q2.getSubject()); // // // //
 * Question q3 = this.questionRepository.findBySubject("스프링 부트 모델 질문입니다"); //
 * System.out.println(q3.getContent()); //
 * System.out.println(q3.getCreateDate());
 * 
 * // // // assertEquals(2, q3.getId()); // //
 * 
 * // select * from question where subject = ? and content = ? //
 * findBySubjectAndContent 제목과 내용이 같은 것을 검색 // findBySubjectLike 지정검색('%' 일부만
 * 일치해도 검색) // findBySubjectOrderByCreateDateAsc 제목을 기준으로 시간을 오름차순 정렬 // select
 * * from question where subject = ? order by createDate asc
 * 
 * // Question q =
 * this.questionRepository.findBySubjectAndContent("sbb는 무엇인가요?",
 * "sbb에 대해서 알고 싶습니다"); // // System.out.println(q.getContent()); //
 * System.out.println(q.getSubject()); // // assertEquals(2, q.getSubject()); //
 * // // List<Question> qList =
 * this.questionRepository.findBySubjectLike("%sbb%"); // // //
 * Optional<Question> oq = this.questionRepository.findById(1); //
 * assertTrue(oq.isPresent()); // Question q = oq.get(); //
 * q.setContent("수정된 내용"); // this.questionRepository.save(q); // 검색하고 맞는지 확인하고
 * 위치를 지정하고 내용을 넣은 후 저장(insert)
 * 
 * // Optional<Question> q = this.questionRepository.findById(2); // Question q1
 * = q.get(); // q가 가지고 있는 것을 q1에 넣어줌 // this.questionRepository.delete(q1);
 * //검색하고 위치를 지정한 후 지정한 위치를 지움
 * 
 * // Optional<Question> oq = this.questionRepository.findById(2); //
 * assertTrue(oq.isPresent()); // Question q = oq.get(); //답변을 작성할 질문을 검색함 // //
 * // Answer a = new Answer(); // a.setContent("답변등록"); // a.setQuestion(q); //
 * a.setCreateDate(LocalDateTime.now()); // this.answerRepository.save(a);
 * 
 * // Answer를 객체로 만들어서 // 만들어진 객체로
 * 
 * // Optional<Answer> oa = this.answerRepository.findById(1); // Answer a =
 * oa.get(); // System.out.println(a.getQuestion().getId()); // //답변의 번호와 그 답변이
 * 달린 질문과 아이디를 출력
 * 
 * // Optional<Question> qq = this.questionRepository.findById(1); // Question q
 * = qq.get(); // // List<Answer> answerList = q.getAnswerList(); // for(Answer
 * list : answerList) { // System.out.println(list.getContent()); //
 * System.out.println(list.getCreateDate()); //
 * System.out.println(list.getQuestion().getContent()); // } }
 * 
 * }
 * 
 * 
 */