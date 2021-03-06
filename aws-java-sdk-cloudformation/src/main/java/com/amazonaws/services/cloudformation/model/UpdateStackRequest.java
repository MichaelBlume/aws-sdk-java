/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cloudformation.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.cloudformation.AmazonCloudFormation#updateStack(UpdateStackRequest) UpdateStack operation}.
 * <p>
 * Updates a stack as specified in the template. After the call completes
 * successfully, the stack update starts. You can check the status of the
 * stack via the DescribeStacks action.
 * </p>
 * <p>
 * To get a copy of the template for an existing stack, you can use the
 * GetTemplate action.
 * </p>
 * <p>
 * Tags that were associated with this stack during creation time will
 * still be associated with the stack after an <code>UpdateStack</code>
 * operation.
 * </p>
 * <p>
 * For more information about creating an update template, updating a
 * stack, and monitoring the progress of the update, see
 * <a href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-cfn-updating-stacks.html"> Updating a Stack </a>
 * .
 * </p>
 *
 * @see com.amazonaws.services.cloudformation.AmazonCloudFormation#updateStack(UpdateStackRequest)
 */
public class UpdateStackRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * The name or stack ID of the stack to update. <note> Must contain only
     * alphanumeric characters (case sensitive) and start with an alpha
     * character. Maximum length of the name is 255 characters. </note>
     */
    private String stackName;

    /**
     * Structure containing the template body with a minimum length of 1 byte
     * and a maximum length of 51,200 bytes. (For more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     */
    private String templateBody;

    /**
     * Location of file containing the template body. The URL must point to a
     * template located in an S3 bucket in the same region as the stack. For
     * more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     */
    private String templateURL;

    /**
     * Reuse the existing template that is associated with the stack that you
     * are updating.
     */
    private Boolean usePreviousTemplate;

    /**
     * Structure containing the temporary overriding stack policy body. You
     * can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     */
    private String stackPolicyDuringUpdateBody;

    /**
     * Location of a file containing the temporary overriding stack policy.
     * The URL must point to a policy (max size: 16KB) located in an S3
     * bucket in the same region as the stack. You can specify either the
     * <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     */
    private String stackPolicyDuringUpdateURL;

    /**
     * A list of <code>Parameter</code> structures that specify input
     * parameters for the stack.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<Parameter> parameters;

    /**
     * A list of capabilities that you must specify before AWS CloudFormation
     * can create or update certain stacks. Some stack templates might
     * include resources that can affect permissions in your AWS account. For
     * those stacks, you must explicitly acknowledge their capabilities by
     * specifying this parameter. Currently, the only valid value is
     * <code>CAPABILITY_IAM</code>, which is required for the following
     * resources: <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     * AWS::CloudFormation::Stack</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     * AWS::IAM::AccessKey</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     * AWS::IAM::Group</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     * AWS::IAM::InstanceProfile</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     * AWS::IAM::Policy</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     * AWS::IAM::Role</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     * AWS::IAM::User</a>, and <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     * AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     * these resources, we recommend that you review any permissions
     * associated with them. If you don't specify this parameter, this action
     * returns an InsufficientCapabilities error.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<String> capabilities;

    /**
     * Structure containing a new stack policy body. You can specify either
     * the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     */
    private String stackPolicyBody;

    /**
     * Location of a file containing the updated stack policy. The URL must
     * point to a policy (max size: 16KB) located in an S3 bucket in the same
     * region as the stack. You can specify either the
     * <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     */
    private String stackPolicyURL;

    /**
     * Update the ARNs for the Amazon SNS topics that are associated with the
     * stack.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 5<br/>
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<String> notificationARNs;

    /**
     * The name or stack ID of the stack to update. <note> Must contain only
     * alphanumeric characters (case sensitive) and start with an alpha
     * character. Maximum length of the name is 255 characters. </note>
     *
     * @return The name or stack ID of the stack to update. <note> Must contain only
     *         alphanumeric characters (case sensitive) and start with an alpha
     *         character. Maximum length of the name is 255 characters. </note>
     */
    public String getStackName() {
        return stackName;
    }
    
    /**
     * The name or stack ID of the stack to update. <note> Must contain only
     * alphanumeric characters (case sensitive) and start with an alpha
     * character. Maximum length of the name is 255 characters. </note>
     *
     * @param stackName The name or stack ID of the stack to update. <note> Must contain only
     *         alphanumeric characters (case sensitive) and start with an alpha
     *         character. Maximum length of the name is 255 characters. </note>
     */
    public void setStackName(String stackName) {
        this.stackName = stackName;
    }
    
    /**
     * The name or stack ID of the stack to update. <note> Must contain only
     * alphanumeric characters (case sensitive) and start with an alpha
     * character. Maximum length of the name is 255 characters. </note>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param stackName The name or stack ID of the stack to update. <note> Must contain only
     *         alphanumeric characters (case sensitive) and start with an alpha
     *         character. Maximum length of the name is 255 characters. </note>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withStackName(String stackName) {
        this.stackName = stackName;
        return this;
    }

    /**
     * Structure containing the template body with a minimum length of 1 byte
     * and a maximum length of 51,200 bytes. (For more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @return Structure containing the template body with a minimum length of 1 byte
     *         and a maximum length of 51,200 bytes. (For more information, go to <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     *         Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     *         must specify either the <code>TemplateBody</code> or the
     *         <code>TemplateURL</code> parameter, but not both.
     */
    public String getTemplateBody() {
        return templateBody;
    }
    
    /**
     * Structure containing the template body with a minimum length of 1 byte
     * and a maximum length of 51,200 bytes. (For more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @param templateBody Structure containing the template body with a minimum length of 1 byte
     *         and a maximum length of 51,200 bytes. (For more information, go to <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     *         Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     *         must specify either the <code>TemplateBody</code> or the
     *         <code>TemplateURL</code> parameter, but not both.
     */
    public void setTemplateBody(String templateBody) {
        this.templateBody = templateBody;
    }
    
    /**
     * Structure containing the template body with a minimum length of 1 byte
     * and a maximum length of 51,200 bytes. (For more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @param templateBody Structure containing the template body with a minimum length of 1 byte
     *         and a maximum length of 51,200 bytes. (For more information, go to <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     *         Anatomy</a> in the AWS CloudFormation User Guide.) <p>Conditional: You
     *         must specify either the <code>TemplateBody</code> or the
     *         <code>TemplateURL</code> parameter, but not both.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withTemplateBody(String templateBody) {
        this.templateBody = templateBody;
        return this;
    }

    /**
     * Location of file containing the template body. The URL must point to a
     * template located in an S3 bucket in the same region as the stack. For
     * more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     *
     * @return Location of file containing the template body. The URL must point to a
     *         template located in an S3 bucket in the same region as the stack. For
     *         more information, go to <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     *         Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     *         must specify either the <code>TemplateBody</code> or the
     *         <code>TemplateURL</code> parameter, but not both.
     */
    public String getTemplateURL() {
        return templateURL;
    }
    
    /**
     * Location of file containing the template body. The URL must point to a
     * template located in an S3 bucket in the same region as the stack. For
     * more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     *
     * @param templateURL Location of file containing the template body. The URL must point to a
     *         template located in an S3 bucket in the same region as the stack. For
     *         more information, go to <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     *         Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     *         must specify either the <code>TemplateBody</code> or the
     *         <code>TemplateURL</code> parameter, but not both.
     */
    public void setTemplateURL(String templateURL) {
        this.templateURL = templateURL;
    }
    
    /**
     * Location of file containing the template body. The URL must point to a
     * template located in an S3 bucket in the same region as the stack. For
     * more information, go to <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     * Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     * must specify either the <code>TemplateBody</code> or the
     * <code>TemplateURL</code> parameter, but not both.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     *
     * @param templateURL Location of file containing the template body. The URL must point to a
     *         template located in an S3 bucket in the same region as the stack. For
     *         more information, go to <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html">Template
     *         Anatomy</a> in the AWS CloudFormation User Guide. <p>Conditional: You
     *         must specify either the <code>TemplateBody</code> or the
     *         <code>TemplateURL</code> parameter, but not both.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withTemplateURL(String templateURL) {
        this.templateURL = templateURL;
        return this;
    }

    /**
     * Reuse the existing template that is associated with the stack that you
     * are updating.
     *
     * @return Reuse the existing template that is associated with the stack that you
     *         are updating.
     */
    public Boolean isUsePreviousTemplate() {
        return usePreviousTemplate;
    }
    
    /**
     * Reuse the existing template that is associated with the stack that you
     * are updating.
     *
     * @param usePreviousTemplate Reuse the existing template that is associated with the stack that you
     *         are updating.
     */
    public void setUsePreviousTemplate(Boolean usePreviousTemplate) {
        this.usePreviousTemplate = usePreviousTemplate;
    }
    
    /**
     * Reuse the existing template that is associated with the stack that you
     * are updating.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param usePreviousTemplate Reuse the existing template that is associated with the stack that you
     *         are updating.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withUsePreviousTemplate(Boolean usePreviousTemplate) {
        this.usePreviousTemplate = usePreviousTemplate;
        return this;
    }

    /**
     * Reuse the existing template that is associated with the stack that you
     * are updating.
     *
     * @return Reuse the existing template that is associated with the stack that you
     *         are updating.
     */
    public Boolean getUsePreviousTemplate() {
        return usePreviousTemplate;
    }

    /**
     * Structure containing the temporary overriding stack policy body. You
     * can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     *
     * @return Structure containing the temporary overriding stack policy body. You
     *         can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     *         <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     *         you want to update protected resources, specify a temporary overriding
     *         stack policy during this update. If you do not specify a stack policy,
     *         the current policy that is associated with the stack will be used.
     */
    public String getStackPolicyDuringUpdateBody() {
        return stackPolicyDuringUpdateBody;
    }
    
    /**
     * Structure containing the temporary overriding stack policy body. You
     * can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     *
     * @param stackPolicyDuringUpdateBody Structure containing the temporary overriding stack policy body. You
     *         can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     *         <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     *         you want to update protected resources, specify a temporary overriding
     *         stack policy during this update. If you do not specify a stack policy,
     *         the current policy that is associated with the stack will be used.
     */
    public void setStackPolicyDuringUpdateBody(String stackPolicyDuringUpdateBody) {
        this.stackPolicyDuringUpdateBody = stackPolicyDuringUpdateBody;
    }
    
    /**
     * Structure containing the temporary overriding stack policy body. You
     * can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     *
     * @param stackPolicyDuringUpdateBody Structure containing the temporary overriding stack policy body. You
     *         can specify either the <code>StackPolicyDuringUpdateBody</code> or the
     *         <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     *         you want to update protected resources, specify a temporary overriding
     *         stack policy during this update. If you do not specify a stack policy,
     *         the current policy that is associated with the stack will be used.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withStackPolicyDuringUpdateBody(String stackPolicyDuringUpdateBody) {
        this.stackPolicyDuringUpdateBody = stackPolicyDuringUpdateBody;
        return this;
    }

    /**
     * Location of a file containing the temporary overriding stack policy.
     * The URL must point to a policy (max size: 16KB) located in an S3
     * bucket in the same region as the stack. You can specify either the
     * <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     *
     * @return Location of a file containing the temporary overriding stack policy.
     *         The URL must point to a policy (max size: 16KB) located in an S3
     *         bucket in the same region as the stack. You can specify either the
     *         <code>StackPolicyDuringUpdateBody</code> or the
     *         <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     *         you want to update protected resources, specify a temporary overriding
     *         stack policy during this update. If you do not specify a stack policy,
     *         the current policy that is associated with the stack will be used.
     */
    public String getStackPolicyDuringUpdateURL() {
        return stackPolicyDuringUpdateURL;
    }
    
    /**
     * Location of a file containing the temporary overriding stack policy.
     * The URL must point to a policy (max size: 16KB) located in an S3
     * bucket in the same region as the stack. You can specify either the
     * <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     *
     * @param stackPolicyDuringUpdateURL Location of a file containing the temporary overriding stack policy.
     *         The URL must point to a policy (max size: 16KB) located in an S3
     *         bucket in the same region as the stack. You can specify either the
     *         <code>StackPolicyDuringUpdateBody</code> or the
     *         <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     *         you want to update protected resources, specify a temporary overriding
     *         stack policy during this update. If you do not specify a stack policy,
     *         the current policy that is associated with the stack will be used.
     */
    public void setStackPolicyDuringUpdateURL(String stackPolicyDuringUpdateURL) {
        this.stackPolicyDuringUpdateURL = stackPolicyDuringUpdateURL;
    }
    
    /**
     * Location of a file containing the temporary overriding stack policy.
     * The URL must point to a policy (max size: 16KB) located in an S3
     * bucket in the same region as the stack. You can specify either the
     * <code>StackPolicyDuringUpdateBody</code> or the
     * <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     * you want to update protected resources, specify a temporary overriding
     * stack policy during this update. If you do not specify a stack policy,
     * the current policy that is associated with the stack will be used.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     *
     * @param stackPolicyDuringUpdateURL Location of a file containing the temporary overriding stack policy.
     *         The URL must point to a policy (max size: 16KB) located in an S3
     *         bucket in the same region as the stack. You can specify either the
     *         <code>StackPolicyDuringUpdateBody</code> or the
     *         <code>StackPolicyDuringUpdateURL</code> parameter, but not both. <p>If
     *         you want to update protected resources, specify a temporary overriding
     *         stack policy during this update. If you do not specify a stack policy,
     *         the current policy that is associated with the stack will be used.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withStackPolicyDuringUpdateURL(String stackPolicyDuringUpdateURL) {
        this.stackPolicyDuringUpdateURL = stackPolicyDuringUpdateURL;
        return this;
    }

    /**
     * A list of <code>Parameter</code> structures that specify input
     * parameters for the stack.
     *
     * @return A list of <code>Parameter</code> structures that specify input
     *         parameters for the stack.
     */
    public java.util.List<Parameter> getParameters() {
        if (parameters == null) {
              parameters = new com.amazonaws.internal.ListWithAutoConstructFlag<Parameter>();
              parameters.setAutoConstruct(true);
        }
        return parameters;
    }
    
    /**
     * A list of <code>Parameter</code> structures that specify input
     * parameters for the stack.
     *
     * @param parameters A list of <code>Parameter</code> structures that specify input
     *         parameters for the stack.
     */
    public void setParameters(java.util.Collection<Parameter> parameters) {
        if (parameters == null) {
            this.parameters = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<Parameter> parametersCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Parameter>(parameters.size());
        parametersCopy.addAll(parameters);
        this.parameters = parametersCopy;
    }
    
    /**
     * A list of <code>Parameter</code> structures that specify input
     * parameters for the stack.
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setParameters(java.util.Collection)} or {@link
     * #withParameters(java.util.Collection)} if you want to override the
     * existing values.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param parameters A list of <code>Parameter</code> structures that specify input
     *         parameters for the stack.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withParameters(Parameter... parameters) {
        if (getParameters() == null) setParameters(new java.util.ArrayList<Parameter>(parameters.length));
        for (Parameter value : parameters) {
            getParameters().add(value);
        }
        return this;
    }
    
    /**
     * A list of <code>Parameter</code> structures that specify input
     * parameters for the stack.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param parameters A list of <code>Parameter</code> structures that specify input
     *         parameters for the stack.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withParameters(java.util.Collection<Parameter> parameters) {
        if (parameters == null) {
            this.parameters = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<Parameter> parametersCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Parameter>(parameters.size());
            parametersCopy.addAll(parameters);
            this.parameters = parametersCopy;
        }

        return this;
    }

    /**
     * A list of capabilities that you must specify before AWS CloudFormation
     * can create or update certain stacks. Some stack templates might
     * include resources that can affect permissions in your AWS account. For
     * those stacks, you must explicitly acknowledge their capabilities by
     * specifying this parameter. Currently, the only valid value is
     * <code>CAPABILITY_IAM</code>, which is required for the following
     * resources: <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     * AWS::CloudFormation::Stack</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     * AWS::IAM::AccessKey</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     * AWS::IAM::Group</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     * AWS::IAM::InstanceProfile</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     * AWS::IAM::Policy</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     * AWS::IAM::Role</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     * AWS::IAM::User</a>, and <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     * AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     * these resources, we recommend that you review any permissions
     * associated with them. If you don't specify this parameter, this action
     * returns an InsufficientCapabilities error.
     *
     * @return A list of capabilities that you must specify before AWS CloudFormation
     *         can create or update certain stacks. Some stack templates might
     *         include resources that can affect permissions in your AWS account. For
     *         those stacks, you must explicitly acknowledge their capabilities by
     *         specifying this parameter. Currently, the only valid value is
     *         <code>CAPABILITY_IAM</code>, which is required for the following
     *         resources: <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     *         AWS::CloudFormation::Stack</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     *         AWS::IAM::AccessKey</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     *         AWS::IAM::Group</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     *         AWS::IAM::InstanceProfile</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     *         AWS::IAM::Policy</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     *         AWS::IAM::Role</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     *         AWS::IAM::User</a>, and <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     *         AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     *         these resources, we recommend that you review any permissions
     *         associated with them. If you don't specify this parameter, this action
     *         returns an InsufficientCapabilities error.
     */
    public java.util.List<String> getCapabilities() {
        if (capabilities == null) {
              capabilities = new com.amazonaws.internal.ListWithAutoConstructFlag<String>();
              capabilities.setAutoConstruct(true);
        }
        return capabilities;
    }
    
    /**
     * A list of capabilities that you must specify before AWS CloudFormation
     * can create or update certain stacks. Some stack templates might
     * include resources that can affect permissions in your AWS account. For
     * those stacks, you must explicitly acknowledge their capabilities by
     * specifying this parameter. Currently, the only valid value is
     * <code>CAPABILITY_IAM</code>, which is required for the following
     * resources: <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     * AWS::CloudFormation::Stack</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     * AWS::IAM::AccessKey</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     * AWS::IAM::Group</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     * AWS::IAM::InstanceProfile</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     * AWS::IAM::Policy</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     * AWS::IAM::Role</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     * AWS::IAM::User</a>, and <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     * AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     * these resources, we recommend that you review any permissions
     * associated with them. If you don't specify this parameter, this action
     * returns an InsufficientCapabilities error.
     *
     * @param capabilities A list of capabilities that you must specify before AWS CloudFormation
     *         can create or update certain stacks. Some stack templates might
     *         include resources that can affect permissions in your AWS account. For
     *         those stacks, you must explicitly acknowledge their capabilities by
     *         specifying this parameter. Currently, the only valid value is
     *         <code>CAPABILITY_IAM</code>, which is required for the following
     *         resources: <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     *         AWS::CloudFormation::Stack</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     *         AWS::IAM::AccessKey</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     *         AWS::IAM::Group</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     *         AWS::IAM::InstanceProfile</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     *         AWS::IAM::Policy</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     *         AWS::IAM::Role</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     *         AWS::IAM::User</a>, and <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     *         AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     *         these resources, we recommend that you review any permissions
     *         associated with them. If you don't specify this parameter, this action
     *         returns an InsufficientCapabilities error.
     */
    public void setCapabilities(java.util.Collection<String> capabilities) {
        if (capabilities == null) {
            this.capabilities = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<String> capabilitiesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(capabilities.size());
        capabilitiesCopy.addAll(capabilities);
        this.capabilities = capabilitiesCopy;
    }
    
    /**
     * A list of capabilities that you must specify before AWS CloudFormation
     * can create or update certain stacks. Some stack templates might
     * include resources that can affect permissions in your AWS account. For
     * those stacks, you must explicitly acknowledge their capabilities by
     * specifying this parameter. Currently, the only valid value is
     * <code>CAPABILITY_IAM</code>, which is required for the following
     * resources: <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     * AWS::CloudFormation::Stack</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     * AWS::IAM::AccessKey</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     * AWS::IAM::Group</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     * AWS::IAM::InstanceProfile</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     * AWS::IAM::Policy</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     * AWS::IAM::Role</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     * AWS::IAM::User</a>, and <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     * AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     * these resources, we recommend that you review any permissions
     * associated with them. If you don't specify this parameter, this action
     * returns an InsufficientCapabilities error.
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setCapabilities(java.util.Collection)} or {@link
     * #withCapabilities(java.util.Collection)} if you want to override the
     * existing values.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param capabilities A list of capabilities that you must specify before AWS CloudFormation
     *         can create or update certain stacks. Some stack templates might
     *         include resources that can affect permissions in your AWS account. For
     *         those stacks, you must explicitly acknowledge their capabilities by
     *         specifying this parameter. Currently, the only valid value is
     *         <code>CAPABILITY_IAM</code>, which is required for the following
     *         resources: <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     *         AWS::CloudFormation::Stack</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     *         AWS::IAM::AccessKey</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     *         AWS::IAM::Group</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     *         AWS::IAM::InstanceProfile</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     *         AWS::IAM::Policy</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     *         AWS::IAM::Role</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     *         AWS::IAM::User</a>, and <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     *         AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     *         these resources, we recommend that you review any permissions
     *         associated with them. If you don't specify this parameter, this action
     *         returns an InsufficientCapabilities error.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withCapabilities(String... capabilities) {
        if (getCapabilities() == null) setCapabilities(new java.util.ArrayList<String>(capabilities.length));
        for (String value : capabilities) {
            getCapabilities().add(value);
        }
        return this;
    }
    
    /**
     * A list of capabilities that you must specify before AWS CloudFormation
     * can create or update certain stacks. Some stack templates might
     * include resources that can affect permissions in your AWS account. For
     * those stacks, you must explicitly acknowledge their capabilities by
     * specifying this parameter. Currently, the only valid value is
     * <code>CAPABILITY_IAM</code>, which is required for the following
     * resources: <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     * AWS::CloudFormation::Stack</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     * AWS::IAM::AccessKey</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     * AWS::IAM::Group</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     * AWS::IAM::InstanceProfile</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     * AWS::IAM::Policy</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     * AWS::IAM::Role</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     * AWS::IAM::User</a>, and <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     * AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     * these resources, we recommend that you review any permissions
     * associated with them. If you don't specify this parameter, this action
     * returns an InsufficientCapabilities error.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param capabilities A list of capabilities that you must specify before AWS CloudFormation
     *         can create or update certain stacks. Some stack templates might
     *         include resources that can affect permissions in your AWS account. For
     *         those stacks, you must explicitly acknowledge their capabilities by
     *         specifying this parameter. Currently, the only valid value is
     *         <code>CAPABILITY_IAM</code>, which is required for the following
     *         resources: <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     *         AWS::CloudFormation::Stack</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     *         AWS::IAM::AccessKey</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     *         AWS::IAM::Group</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     *         AWS::IAM::InstanceProfile</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     *         AWS::IAM::Policy</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     *         AWS::IAM::Role</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     *         AWS::IAM::User</a>, and <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     *         AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     *         these resources, we recommend that you review any permissions
     *         associated with them. If you don't specify this parameter, this action
     *         returns an InsufficientCapabilities error.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withCapabilities(java.util.Collection<String> capabilities) {
        if (capabilities == null) {
            this.capabilities = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<String> capabilitiesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(capabilities.size());
            capabilitiesCopy.addAll(capabilities);
            this.capabilities = capabilitiesCopy;
        }

        return this;
    }

    /**
     * A list of capabilities that you must specify before AWS CloudFormation
     * can create or update certain stacks. Some stack templates might
     * include resources that can affect permissions in your AWS account. For
     * those stacks, you must explicitly acknowledge their capabilities by
     * specifying this parameter. Currently, the only valid value is
     * <code>CAPABILITY_IAM</code>, which is required for the following
     * resources: <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     * AWS::CloudFormation::Stack</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     * AWS::IAM::AccessKey</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     * AWS::IAM::Group</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     * AWS::IAM::InstanceProfile</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     * AWS::IAM::Policy</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     * AWS::IAM::Role</a>, <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     * AWS::IAM::User</a>, and <a
     * href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     * AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     * these resources, we recommend that you review any permissions
     * associated with them. If you don't specify this parameter, this action
     * returns an InsufficientCapabilities error.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param capabilities A list of capabilities that you must specify before AWS CloudFormation
     *         can create or update certain stacks. Some stack templates might
     *         include resources that can affect permissions in your AWS account. For
     *         those stacks, you must explicitly acknowledge their capabilities by
     *         specifying this parameter. Currently, the only valid value is
     *         <code>CAPABILITY_IAM</code>, which is required for the following
     *         resources: <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-stack.html">
     *         AWS::CloudFormation::Stack</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-accesskey.html">
     *         AWS::IAM::AccessKey</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-group.html">
     *         AWS::IAM::Group</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-instanceprofile.html">
     *         AWS::IAM::InstanceProfile</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-policy.html">
     *         AWS::IAM::Policy</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iam-role.html">
     *         AWS::IAM::Role</a>, <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-user.html">
     *         AWS::IAM::User</a>, and <a
     *         href="http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-addusertogroup.html">
     *         AWS::IAM::UserToGroupAddition</a>. If your stack template contains
     *         these resources, we recommend that you review any permissions
     *         associated with them. If you don't specify this parameter, this action
     *         returns an InsufficientCapabilities error.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withCapabilities(Capability... capabilities) {
        java.util.ArrayList<String> capabilitiesCopy = new java.util.ArrayList<String>(capabilities.length);
        for (Capability member : capabilities) {
            capabilitiesCopy.add(member.toString());
        }
        if (getCapabilities() == null) {
            setCapabilities(capabilitiesCopy);
        } else {
            getCapabilities().addAll(capabilitiesCopy);
        }
        return this;
    }

    /**
     * Structure containing a new stack policy body. You can specify either
     * the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     *
     * @return Structure containing a new stack policy body. You can specify either
     *         the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     *         parameter, but not both. <p>You might update the stack policy, for
     *         example, in order to protect a new resource that you created during a
     *         stack update. If you do not specify a stack policy, the current policy
     *         that is associated with the stack is unchanged.
     */
    public String getStackPolicyBody() {
        return stackPolicyBody;
    }
    
    /**
     * Structure containing a new stack policy body. You can specify either
     * the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     *
     * @param stackPolicyBody Structure containing a new stack policy body. You can specify either
     *         the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     *         parameter, but not both. <p>You might update the stack policy, for
     *         example, in order to protect a new resource that you created during a
     *         stack update. If you do not specify a stack policy, the current policy
     *         that is associated with the stack is unchanged.
     */
    public void setStackPolicyBody(String stackPolicyBody) {
        this.stackPolicyBody = stackPolicyBody;
    }
    
    /**
     * Structure containing a new stack policy body. You can specify either
     * the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 16384<br/>
     *
     * @param stackPolicyBody Structure containing a new stack policy body. You can specify either
     *         the <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     *         parameter, but not both. <p>You might update the stack policy, for
     *         example, in order to protect a new resource that you created during a
     *         stack update. If you do not specify a stack policy, the current policy
     *         that is associated with the stack is unchanged.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withStackPolicyBody(String stackPolicyBody) {
        this.stackPolicyBody = stackPolicyBody;
        return this;
    }

    /**
     * Location of a file containing the updated stack policy. The URL must
     * point to a policy (max size: 16KB) located in an S3 bucket in the same
     * region as the stack. You can specify either the
     * <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     *
     * @return Location of a file containing the updated stack policy. The URL must
     *         point to a policy (max size: 16KB) located in an S3 bucket in the same
     *         region as the stack. You can specify either the
     *         <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     *         parameter, but not both. <p>You might update the stack policy, for
     *         example, in order to protect a new resource that you created during a
     *         stack update. If you do not specify a stack policy, the current policy
     *         that is associated with the stack is unchanged.
     */
    public String getStackPolicyURL() {
        return stackPolicyURL;
    }
    
    /**
     * Location of a file containing the updated stack policy. The URL must
     * point to a policy (max size: 16KB) located in an S3 bucket in the same
     * region as the stack. You can specify either the
     * <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     *
     * @param stackPolicyURL Location of a file containing the updated stack policy. The URL must
     *         point to a policy (max size: 16KB) located in an S3 bucket in the same
     *         region as the stack. You can specify either the
     *         <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     *         parameter, but not both. <p>You might update the stack policy, for
     *         example, in order to protect a new resource that you created during a
     *         stack update. If you do not specify a stack policy, the current policy
     *         that is associated with the stack is unchanged.
     */
    public void setStackPolicyURL(String stackPolicyURL) {
        this.stackPolicyURL = stackPolicyURL;
    }
    
    /**
     * Location of a file containing the updated stack policy. The URL must
     * point to a policy (max size: 16KB) located in an S3 bucket in the same
     * region as the stack. You can specify either the
     * <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     * parameter, but not both. <p>You might update the stack policy, for
     * example, in order to protect a new resource that you created during a
     * stack update. If you do not specify a stack policy, the current policy
     * that is associated with the stack is unchanged.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1350<br/>
     *
     * @param stackPolicyURL Location of a file containing the updated stack policy. The URL must
     *         point to a policy (max size: 16KB) located in an S3 bucket in the same
     *         region as the stack. You can specify either the
     *         <code>StackPolicyBody</code> or the <code>StackPolicyURL</code>
     *         parameter, but not both. <p>You might update the stack policy, for
     *         example, in order to protect a new resource that you created during a
     *         stack update. If you do not specify a stack policy, the current policy
     *         that is associated with the stack is unchanged.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withStackPolicyURL(String stackPolicyURL) {
        this.stackPolicyURL = stackPolicyURL;
        return this;
    }

    /**
     * Update the ARNs for the Amazon SNS topics that are associated with the
     * stack.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 5<br/>
     *
     * @return Update the ARNs for the Amazon SNS topics that are associated with the
     *         stack.
     */
    public java.util.List<String> getNotificationARNs() {
        if (notificationARNs == null) {
              notificationARNs = new com.amazonaws.internal.ListWithAutoConstructFlag<String>();
              notificationARNs.setAutoConstruct(true);
        }
        return notificationARNs;
    }
    
    /**
     * Update the ARNs for the Amazon SNS topics that are associated with the
     * stack.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 5<br/>
     *
     * @param notificationARNs Update the ARNs for the Amazon SNS topics that are associated with the
     *         stack.
     */
    public void setNotificationARNs(java.util.Collection<String> notificationARNs) {
        if (notificationARNs == null) {
            this.notificationARNs = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<String> notificationARNsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(notificationARNs.size());
        notificationARNsCopy.addAll(notificationARNs);
        this.notificationARNs = notificationARNsCopy;
    }
    
    /**
     * Update the ARNs for the Amazon SNS topics that are associated with the
     * stack.
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if
     * any). Use {@link #setNotificationARNs(java.util.Collection)} or {@link
     * #withNotificationARNs(java.util.Collection)} if you want to override
     * the existing values.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 5<br/>
     *
     * @param notificationARNs Update the ARNs for the Amazon SNS topics that are associated with the
     *         stack.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withNotificationARNs(String... notificationARNs) {
        if (getNotificationARNs() == null) setNotificationARNs(new java.util.ArrayList<String>(notificationARNs.length));
        for (String value : notificationARNs) {
            getNotificationARNs().add(value);
        }
        return this;
    }
    
    /**
     * Update the ARNs for the Amazon SNS topics that are associated with the
     * stack.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 5<br/>
     *
     * @param notificationARNs Update the ARNs for the Amazon SNS topics that are associated with the
     *         stack.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public UpdateStackRequest withNotificationARNs(java.util.Collection<String> notificationARNs) {
        if (notificationARNs == null) {
            this.notificationARNs = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<String> notificationARNsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(notificationARNs.size());
            notificationARNsCopy.addAll(notificationARNs);
            this.notificationARNs = notificationARNsCopy;
        }

        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getStackName() != null) sb.append("StackName: " + getStackName() + ",");
        if (getTemplateBody() != null) sb.append("TemplateBody: " + getTemplateBody() + ",");
        if (getTemplateURL() != null) sb.append("TemplateURL: " + getTemplateURL() + ",");
        if (isUsePreviousTemplate() != null) sb.append("UsePreviousTemplate: " + isUsePreviousTemplate() + ",");
        if (getStackPolicyDuringUpdateBody() != null) sb.append("StackPolicyDuringUpdateBody: " + getStackPolicyDuringUpdateBody() + ",");
        if (getStackPolicyDuringUpdateURL() != null) sb.append("StackPolicyDuringUpdateURL: " + getStackPolicyDuringUpdateURL() + ",");
        if (getParameters() != null) sb.append("Parameters: " + getParameters() + ",");
        if (getCapabilities() != null) sb.append("Capabilities: " + getCapabilities() + ",");
        if (getStackPolicyBody() != null) sb.append("StackPolicyBody: " + getStackPolicyBody() + ",");
        if (getStackPolicyURL() != null) sb.append("StackPolicyURL: " + getStackPolicyURL() + ",");
        if (getNotificationARNs() != null) sb.append("NotificationARNs: " + getNotificationARNs() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getStackName() == null) ? 0 : getStackName().hashCode()); 
        hashCode = prime * hashCode + ((getTemplateBody() == null) ? 0 : getTemplateBody().hashCode()); 
        hashCode = prime * hashCode + ((getTemplateURL() == null) ? 0 : getTemplateURL().hashCode()); 
        hashCode = prime * hashCode + ((isUsePreviousTemplate() == null) ? 0 : isUsePreviousTemplate().hashCode()); 
        hashCode = prime * hashCode + ((getStackPolicyDuringUpdateBody() == null) ? 0 : getStackPolicyDuringUpdateBody().hashCode()); 
        hashCode = prime * hashCode + ((getStackPolicyDuringUpdateURL() == null) ? 0 : getStackPolicyDuringUpdateURL().hashCode()); 
        hashCode = prime * hashCode + ((getParameters() == null) ? 0 : getParameters().hashCode()); 
        hashCode = prime * hashCode + ((getCapabilities() == null) ? 0 : getCapabilities().hashCode()); 
        hashCode = prime * hashCode + ((getStackPolicyBody() == null) ? 0 : getStackPolicyBody().hashCode()); 
        hashCode = prime * hashCode + ((getStackPolicyURL() == null) ? 0 : getStackPolicyURL().hashCode()); 
        hashCode = prime * hashCode + ((getNotificationARNs() == null) ? 0 : getNotificationARNs().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof UpdateStackRequest == false) return false;
        UpdateStackRequest other = (UpdateStackRequest)obj;
        
        if (other.getStackName() == null ^ this.getStackName() == null) return false;
        if (other.getStackName() != null && other.getStackName().equals(this.getStackName()) == false) return false; 
        if (other.getTemplateBody() == null ^ this.getTemplateBody() == null) return false;
        if (other.getTemplateBody() != null && other.getTemplateBody().equals(this.getTemplateBody()) == false) return false; 
        if (other.getTemplateURL() == null ^ this.getTemplateURL() == null) return false;
        if (other.getTemplateURL() != null && other.getTemplateURL().equals(this.getTemplateURL()) == false) return false; 
        if (other.isUsePreviousTemplate() == null ^ this.isUsePreviousTemplate() == null) return false;
        if (other.isUsePreviousTemplate() != null && other.isUsePreviousTemplate().equals(this.isUsePreviousTemplate()) == false) return false; 
        if (other.getStackPolicyDuringUpdateBody() == null ^ this.getStackPolicyDuringUpdateBody() == null) return false;
        if (other.getStackPolicyDuringUpdateBody() != null && other.getStackPolicyDuringUpdateBody().equals(this.getStackPolicyDuringUpdateBody()) == false) return false; 
        if (other.getStackPolicyDuringUpdateURL() == null ^ this.getStackPolicyDuringUpdateURL() == null) return false;
        if (other.getStackPolicyDuringUpdateURL() != null && other.getStackPolicyDuringUpdateURL().equals(this.getStackPolicyDuringUpdateURL()) == false) return false; 
        if (other.getParameters() == null ^ this.getParameters() == null) return false;
        if (other.getParameters() != null && other.getParameters().equals(this.getParameters()) == false) return false; 
        if (other.getCapabilities() == null ^ this.getCapabilities() == null) return false;
        if (other.getCapabilities() != null && other.getCapabilities().equals(this.getCapabilities()) == false) return false; 
        if (other.getStackPolicyBody() == null ^ this.getStackPolicyBody() == null) return false;
        if (other.getStackPolicyBody() != null && other.getStackPolicyBody().equals(this.getStackPolicyBody()) == false) return false; 
        if (other.getStackPolicyURL() == null ^ this.getStackPolicyURL() == null) return false;
        if (other.getStackPolicyURL() != null && other.getStackPolicyURL().equals(this.getStackPolicyURL()) == false) return false; 
        if (other.getNotificationARNs() == null ^ this.getNotificationARNs() == null) return false;
        if (other.getNotificationARNs() != null && other.getNotificationARNs().equals(this.getNotificationARNs()) == false) return false; 
        return true;
    }
    
    @Override
    public UpdateStackRequest clone() {
        
            return (UpdateStackRequest) super.clone();
    }

}
    