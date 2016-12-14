package com.lcc.secure;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * 实现不穿件session的factory
 */
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    @Override
    public Subject createSubject(SubjectContext context) {
        //不创建session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
