<#import "template.ftl" as template>
<@template.form>
    <h1 class="h3 mb-4 fw-normal" id="auth_login_title"><@t key="auth_login_title" /></h1>

    <#if error??>
        <div id="alert-error" class="alert alert-danger" role="alert"><@t key=error /></div>
    </#if>

    <div class="form-floating">
        <input type="email" class="form-control" id="email" name="email" required>
        <label for="email"><@t key="auth_field_email" /></label>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="password" name="password" required>
        <label for="password"><@t key="auth_field_password" /></label>
    </div>

    <button class="w-100 btn btn-lg btn-danger" type="submit"><@t key="auth_field_login" /></button>
</@template.form>
