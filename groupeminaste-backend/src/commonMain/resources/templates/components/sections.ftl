<#macro projects projects projectsCategories>
    <!-- ====== Portfolio Section Start  -->
    <section id="portfolio" class="pt-[120px] pb-[70px] bg-[#f8f9ff]">
        <div class="container">
            <div class="flex flex-wrap mx-[-16px]">
                <div class="w-full px-4">
                    <div class="max-w-[600px] mx-auto text-center mb-[50px]">
                        <span class="font-semibold text-lg text-primary block mb-2"><@t key="home_projects_headline" /></span>
                        <h2 class="font-bold text-black text-3xl sm:text-4xl md:text-[45px] mb-5"><@t key="home_projects_title" /></h2>
                        <p class="font-medium text-lg text-body-color"><@t key="home_projects_description" /></p>
                    </div>
                </div>
                <div class="w-full px-4">
                    <div class="portfolio-buttons flex flex-wrap items-center justify-center mb-12">
                        <button class="sm:font-semibold text-sm sm:text-base block py-2 px-5 md:mx-2 mb-2 rounded-full text-body-color active"
                                data-filter="*"><@t key="home_projects_category_all" />
                        </button>
                        <#list projectsCategories as category>
                            <button class="sm:font-semibold text-sm sm:text-base block py-2 px-5 md:mx-2 mb-2 rounded-full text-body-color"
                                    data-filter=".${category}">${category}
                            </button>
                        </#list>
                    </div>
                </div>
            </div>

            <div class="portfolio-container flex justify-center -mx-4">
                <div class="w-full xl:w-10/12 px-4">
                    <div class="items-wrapper flex flex-wrap justify-center mx-[-16px]">
                        <#list projects as project>
                            <div class="w-full md:w-1/2 px-4 item ${project.category}">
                                <div class="mb-12">
                                    <div class="relative group mb-8 overflow-hidden shadow-service rounded-md">
                                        <img src="${project.image}" alt="image" class="w-full"/>
                                        <div
                                                class="absolute w-full h-full top-0 left-0 bg-primary bg-opacity-[17%] flex items-center justify-center opacity-0 invisible group-hover:opacity-100 group-hover:visible transition"
                                        >
                                            <a href="${project.image}"
                                               class="glightbox w-10 h-10 flex items-center justify-center bg-primary text-white rounded-full">
                                                <svg width="14" height="14" viewBox="0 0 14 14" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M14 8H8V14H6V8H0V6H6V0H8V6H14V8Z" fill="white"/>
                                                </svg>
                                            </a>
                                        </div>
                                    </div>
                                    <h3 class="mt-6">
                                        <a href="/${locale}/projects/${project.id}"
                                           class="font-semibold text-black hover:text-primary text-xl inline-block mb-3">
                                            ${project.name} </a>
                                    </h3>
                                    <p class="font-medium text-base text-body-color">${project.description}</p>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ====== Portfolio Section End  -->
</#macro>

<#macro team users>
    <!-- ====== Team Section Start -->
    <section class="pt-20 lg:pt-[120px]">
        <div class="container">
            <div class="flex flex-wrap -mx-4">
                <div class="w-full px-4">
                    <div class="text-center mx-auto mb-[60px] max-w-[510px]">
                        <span class="font-semibold text-lg text-primary mb-2 block"><@t key="home_team_headline" /></span>
                        <h2 class="font-bold text-3xl sm:text-4xl md:text-[40px] text-dark mb-4"><@t key="home_team_title" /></h2>
                        <p class="text-base text-body-color"><@t key="home_team_description" /></p>
                    </div>
                </div>
            </div>

            <div class="flex flex-wrap justify-center -mx-4">
                <#list users as user>
                    <div class="w-full md:w-1/2 xl:w-1/4 px-4">
                        <div class="max-w-[370px] w-full mx-auto mb-10">
                            <div class="relative rounded-lg overflow-hidden">
                                <img src="${user.avatar}" alt="image" class="w-full"/>
                                <div class="absolute w-full bottom-5 left-0 text-center">
                                    <div class="bg-white relative rounded-lg overflow-hidden mx-5 py-5 px-3">
                                        <h3 class="text-base font-semibold text-dark">${user.name}</h3>
                                        <p class="text-sm text-body-color">${user.biography}</p>
                                        <div>
                                            <span class="absolute left-0 bottom-0">
                                                <svg width="61" height="30" viewBox="0 0 61 30" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg">
                                                    <circle cx="16" cy="45" r="45" fill="#13C296" fill-opacity="0.11"/>
                                                </svg>
                                            </span>
                                            <span class="absolute top-0 right-0">
                                                <svg width="20" height="25" viewBox="0 0 20 25" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg">
                                                    <circle cx="0.706257" cy="24.3533" r="0.646687"
                                                            transform="rotate(-90 0.706257 24.3533)"
                                                            fill="#3056D3"/>
                                                    <circle cx="6.39669" cy="24.3533" r="0.646687"
                                                            transform="rotate(-90 6.39669 24.3533)"
                                                            fill="#3056D3"/>
                                                    <circle cx="12.0881" cy="24.3533" r="0.646687"
                                                            transform="rotate(-90 12.0881 24.3533)"
                                                            fill="#3056D3"/>
                                                    <circle cx="17.7785" cy="24.3533" r="0.646687"
                                                            transform="rotate(-90 17.7785 24.3533)"
                                                            fill="#3056D3"/>
                                                    <circle cx="0.706257" cy="18.6624" r="0.646687"
                                                            transform="rotate(-90 0.706257 18.6624)"
                                                            fill="#3056D3"/>
                                                    <circle cx="6.39669" cy="18.6624" r="0.646687"
                                                            transform="rotate(-90 6.39669 18.6624)"
                                                            fill="#3056D3"/>
                                                    <circle cx="12.0881" cy="18.6624" r="0.646687"
                                                            transform="rotate(-90 12.0881 18.6624)"
                                                            fill="#3056D3"/>
                                                    <circle cx="17.7785" cy="18.6624" r="0.646687"
                                                            transform="rotate(-90 17.7785 18.6624)"
                                                            fill="#3056D3"/>
                                                    <circle cx="0.706257" cy="12.9717" r="0.646687"
                                                            transform="rotate(-90 0.706257 12.9717)"
                                                            fill="#3056D3"/>
                                                    <circle cx="6.39669" cy="12.9717" r="0.646687"
                                                            transform="rotate(-90 6.39669 12.9717)"
                                                            fill="#3056D3"/>
                                                    <circle cx="12.0881" cy="12.9717" r="0.646687"
                                                            transform="rotate(-90 12.0881 12.9717)"
                                                            fill="#3056D3"/>
                                                    <circle cx="17.7785" cy="12.9717" r="0.646687"
                                                            transform="rotate(-90 17.7785 12.9717)"
                                                            fill="#3056D3"/>
                                                    <circle cx="0.706257" cy="7.28077" r="0.646687"
                                                            transform="rotate(-90 0.706257 7.28077)"
                                                            fill="#3056D3"/>
                                                    <circle cx="6.39669" cy="7.28077" r="0.646687"
                                                            transform="rotate(-90 6.39669 7.28077)"
                                                            fill="#3056D3"/>
                                                    <circle cx="12.0881" cy="7.28077" r="0.646687"
                                                            transform="rotate(-90 12.0881 7.28077)"
                                                            fill="#3056D3"/>
                                                    <circle cx="17.7785" cy="7.28077" r="0.646687"
                                                            transform="rotate(-90 17.7785 7.28077)"
                                                            fill="#3056D3"/>
                                                    <circle cx="0.706257" cy="1.58989" r="0.646687"
                                                            transform="rotate(-90 0.706257 1.58989)"
                                                            fill="#3056D3"/>
                                                    <circle cx="6.39669" cy="1.58989" r="0.646687"
                                                            transform="rotate(-90 6.39669 1.58989)"
                                                            fill="#3056D3"/>
                                                    <circle cx="12.0881" cy="1.58989" r="0.646687"
                                                            transform="rotate(-90 12.0881 1.58989)"
                                                            fill="#3056D3"/>
                                                    <circle cx="17.7785" cy="1.58989" r="0.646687"
                                                            transform="rotate(-90 17.7785 1.58989)"
                                                            fill="#3056D3"/>
                                                </svg>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </section>
    <!-- ====== Team Section End -->
</#macro>

<#macro contact>
    <!-- ====== Contact Section Start  -->
    <section id="contact" class="py-[120px]">
        <div class="container">
            <div class="flex flex-wrap mx-[-16px]">
                <div class="w-full px-4">
                    <div class="max-w-[600px] mx-auto text-center mb-[50px]">
                        <span class="font-semibold text-lg text-primary block mb-2"><@t key="home_contact_headline" /></span>
                        <h2 class="font-bold text-black text-3xl sm:text-4xl md:text-[45px] mb-5"><@t key="home_contact_title" /></h2>
                        <p class="font-medium text-lg text-body-color"><@t key="home_contact_description" /></p>
                    </div>
                </div>
            </div>
            <div class="flex justify-center -mx-4">
                <div class="w-full lg:w-9/12 px-4">
                    <form>
                        <div class="flex flex-wrap -mx-4">
                            <div class="w-full md:w-1/2 px-4">
                                <div class="mb-6">
                                    <input type="text" placeholder="<@t key="home_contact_field_name" />"
                                           class="input-field"/>
                                </div>
                            </div>
                            <div class="w-full md:w-1/2 px-4">
                                <div class="mb-6">
                                    <input type="email" placeholder="<@t key="home_contact_field_email" />"
                                           class="input-field"/>
                                </div>
                            </div>
                            <div class="w-full px-4">
                                <div class="mb-6">
                                    <textarea rows="4" placeholder="<@t key="home_contact_field_tell_us" />"
                                              class="input-field resize-none"></textarea>
                                </div>
                            </div>
                            <div class="w-full px-4">
                                <div class="pt-4 text-center">
                                    <button class="inline-flex justify-center items-center py-4 px-9 rounded-full font-semibold text-white bg-primary mx-auto transition duration-300 ease-in-out hover:shadow-signUp hover:bg-opacity-90">
                                        <@t key="home_contact_field_send" />
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!-- ====== Contact Section End  -->
</#macro>
