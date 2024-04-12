<#import "../template.ftl" as template>
<@template.page>
    <section id="contact" class="py-[120px]">
        <div class="container">
            <div class="flex flex-wrap mx-[-16px]">
                <div class="w-full px-4">
                    <div class="max-w-[600px] mx-auto text-center mb-[50px]">
                        <span class="font-semibold text-lg text-primary block mb-2"><@t key="home_contact_headline" /></span>
                        <h2 class="font-bold text-black text-3xl sm:text-4xl md:text-[45px] mb-5"><@t key="home_contact_title" /></h2>
                        <p class="font-medium text-lg text-body-color"><@t key="home_contact_confirmation" /></p>

                        <a href="/${locale}"
                           class="pt-4 inline-flex justify-center items-center py-4 px-9 rounded-full font-semibold text-white bg-primary mx-auto transition duration-300 ease-in-out hover:shadow-signUp hover:bg-opacity-90">
                            <@t key="home_contact_back" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</@template.page>
