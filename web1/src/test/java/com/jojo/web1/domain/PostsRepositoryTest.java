package com.jojo.web1.domain;

import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

//    @After
    public void cleanup() {
        /** 
        ���� �׽�Ʈ �ڵ忡 ������ ��ġ�� �ʱ� ���� 
        �׽�Ʈ �޼ҵ尡 ������ ���� respository ��ü ���� �ڵ�
        **/
        postsRepository.deleteAll();
    }

    @Test
    public void �Խñ�����_�ҷ�����() {
        //given
        postsRepository.save(Posts.builder()
                .title("�׽�Ʈ �Խñ�")
                .content("�׽�Ʈ ����")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("�׽�Ʈ �Խñ�"));
        assertThat(posts.getContent(), is("�׽�Ʈ ����"));
    }
}