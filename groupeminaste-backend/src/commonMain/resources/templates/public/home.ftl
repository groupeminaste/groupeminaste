<#import "../template.ftl" as template>
<#import "../components/sections.ftl" as sections>
<@template.page>
    <!-- ====== Hero Section Start -->
    <div id="home" class="relative pt-[120px] lg:pt-[150px] pb-[110px] bg-white">
        <div class="container">
            <div class="flex flex-wrap -mx-4">
                <div class="w-full lg:w-5/12 px-4">
                    <div class="hero-content">
                        <h1 class="text-dark font-bold text-4xl sm:text-[42px] lg:text-[40px] xl:text-[42px] leading-snug mb-3">
                            <@t key="home_hero_title" />
                        </h1>
                        <p class="text-base mb-8 text-body-color max-w-[480px]">
                            <@t key="home_hero_description" />
                        </p>
                    </div>
                    <div class="connect">
                        <h3 class="font-semibold text-black text-2xl md:text-3xl mb-6"><@t key="home_connect_title" /></h3>
                        <p class="font-medium text-base text-body-color mb-10"><@t key="home_connect_description" /></p>
                        <div class="flex items-center">
                            <a href="https://github.com/groupeminaste"
                               class="w-9 h-9 mr-3 rounded-full flex items-center justify-center border border-[#E5E8F2] text-body-color hover:bg-primary hover:border-primary hover:text-white"
                               aria-label="social-link">
                                <i class="fab fa-github"></i>
                            </a>
                            <a href="https://twitter.com/GroupeMINASTE"
                               class="w-9 h-9 mr-3 rounded-full flex items-center justify-center border border-[#E5E8F2] text-body-color hover:bg-primary hover:border-primary hover:text-white"
                               aria-label="social-link">
                                <i class="fab fa-twitter"></i>
                            </a>
                            <a href="https://groupe-minaste.org/discord"
                               class="w-9 h-9 mr-3 rounded-full flex items-center justify-center border border-[#E5E8F2] text-body-color hover:bg-primary hover:border-primary hover:text-white"
                               aria-label="social-link">
                                <i class="fab fa-discord"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="hidden lg:block lg:w-1/12 px-4"></div>
                <div class="w-full lg:w-6/12 px-4">
                    <div class="lg:text-right lg:ml-auto">
                        <div class="relative inline-block z-10 pt-11 lg:pt-0">
                            <img src="/img/home/hero.png" alt="hero" class="max-w-full lg:ml-auto"/>
                            <span class="absolute -left-8 -bottom-8 z-[-1]">
                                <svg width="93" height="93" viewBox="0 0 93 93" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <circle cx="2.5" cy="2.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="2.5" cy="24.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="2.5" cy="46.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="2.5" cy="68.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="2.5" cy="90.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="24.5" cy="2.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="24.5" cy="24.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="24.5" cy="46.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="24.5" cy="68.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="24.5" cy="90.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="46.5" cy="2.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="46.5" cy="24.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="46.5" cy="46.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="46.5" cy="68.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="46.5" cy="90.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="68.5" cy="2.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="68.5" cy="24.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="68.5" cy="46.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="68.5" cy="68.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="68.5" cy="90.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="90.5" cy="2.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="90.5" cy="24.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="90.5" cy="46.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="90.5" cy="68.5" r="2.5" fill="#3056D3"/>
                                    <circle cx="90.5" cy="90.5" r="2.5" fill="#3056D3"/>
                                </svg>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ====== Hero Section End -->

    <!-- ====== Services Section Start -->
    <section id="services" class="bg-black pt-20 lg:pt-[120px] pb-12 lg:pb-[90px]">
        <div class="container">
            <div class="flex flex-wrap items-end -mx-4 mb-10 lg:mb-[60px]">
                <div class="w-full lg:w-8/12 px-4">
                    <div class="max-w-[625px] mb-5">
                        <span class="font-semibold text-lg text-primary mb-2 block"><@t key="home_services_headline" /></span>
                        <h2 class="font-bold text-3xl sm:text-4xl md:text-[40px] text-white"><@t key="home_services_title" /></h2>
                    </div>
                </div>
            </div>
            <div class="flex flex-wrap justify-center -mx-4">
                <div class="w-full md:w-1/2 lg:w-1/3 px-4">
                    <div class="bg-white mb-10">
                        <img src="/img/services/web.jpg" alt="image" class="w-full"/>
                        <div class="p-8 sm:p-11 md:p-8 lg:px-6 xl:p-10 2xl:p-11">
                            <h3 class="font-bold text-dark text-lg sm:text-xl block mb-4">
                                <@t key="home_services_web_title" />
                            </h3>
                            <p class="text-base text-body-color leading-relaxed">
                                <@t key="home_services_web_description" />
                            </p>
                        </div>
                    </div>
                </div>
                <div class="w-full md:w-1/2 lg:w-1/3 px-4">
                    <div class="bg-white mb-10">
                        <img src="/img/services/mobile.jpg" alt="image" class="w-full"/>
                        <div class="p-8 sm:p-11 md:p-8 lg:px-6 xl:p-10 2xl:p-11">
                            <h3 class="font-bold text-dark text-lg sm:text-xl block mb-4">
                                <@t key="home_services_mobile_title" />
                            </h3>
                            <p class="text-base text-body-color leading-relaxed">
                                <@t key="home_services_mobile_description" />
                            </p>
                        </div>
                    </div>
                </div>
                <div class="w-full md:w-1/2 lg:w-1/3 px-4">
                    <div class="bg-white mb-10">
                        <img src="/img/services/design.jpg" alt="image" class="w-full"/>
                        <div class="p-8 sm:p-11 md:p-8 lg:px-6 xl:p-10 2xl:p-11">
                            <h3 class="font-bold text-dark text-lg sm:text-xl block mb-4">
                                <@t key="home_services_design_title" />
                            </h3>
                            <p class="text-base text-body-color leading-relaxed">
                                <@t key="home_services_design_description" />
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ====== Services Section End -->

    <@sections.projects projects projectsCategories />

    <!-- ====== Clients Section Start  -->
    <!--
    <section id="clients" class="pt-20 pb-[250px] bg-black relative">
        <div class="container">
            <div class="flex flex-wrap mx-[-16px]">
                <div class="w-full px-4">
                    <div class="max-w-[570px] mx-auto mb-12 text-center">
                        <h2 class="font-bold text-3xl md:text-4xl text-white mb-4">Some of Our Happy Clients</h2>
                        <p class="font-medium text-lg text-body-color">There are many variations of passages of Lorem
                            Ipsum available but the majority have suffered alteration in some form.</p>
                    </div>
                </div>
                <div class="w-full px-4">
                    <div
                            class="flex flex-wrap items-center justify-center wow fadeInUp"
                            data-wow-delay=".1s
              "
                    >
                        <a
                                href="https://uideck.com"
                                target="_blank"
                                rel="nofollow noreferrer"
                                class="flex items-center justify-center max-w-[120px] lg:max-w-[130px] xl:max-w-[150px] 2xl:max-w-[160px] mx-3 sm:mx-4 xl:mx-6 2xl:mx-8 py-[15px] grayscale hover:grayscale-0 opacity-60 hover:opacity-100 transition"
                        >
                            <img src="src/images/brands/uideck.svg" alt="uideck"/>
                        </a>
                        <a
                                href="https://tailgrids.com"
                                target="_blank"
                                rel="nofollow noreferrer"
                                class="flex items-center justify-center max-w-[120px] lg:max-w-[130px] xl:max-w-[150px] 2xl:max-w-[160px] mx-3 sm:mx-4 xl:mx-6 2xl:mx-8 py-[15px] grayscale hover:grayscale-0 opacity-60 hover:opacity-100 transition"
                        >
                            <img src="src/images/brands/tailgrids.svg" alt="tailgrids"/>
                        </a>
                        <a
                                href="https://lineicons.com"
                                target="_blank"
                                rel="nofollow noreferrer"
                                class="flex items-center justify-center max-w-[120px] lg:max-w-[130px] xl:max-w-[150px] 2xl:max-w-[160px] mx-3 sm:mx-4 xl:mx-6 2xl:mx-8 py-[15px] grayscale hover:grayscale-0 opacity-60 hover:opacity-100 transition"
                        >
                            <img src="src/images/brands/lineicons.svg" alt="lineicons"/>
                        </a>
                        <a
                                href="https://ayroui.com"
                                target="_blank"
                                rel="nofollow noreferrer"
                                class="flex items-center justify-center max-w-[120px] lg:max-w-[130px] xl:max-w-[150px] 2xl:max-w-[160px] mx-3 sm:mx-4 xl:mx-6 2xl:mx-8 py-[15px] grayscale hover:grayscale-0 opacity-60 hover:opacity-100 transition"
                        >
                            <img src="src/images/brands/ayroui.svg" alt="ayroui"/>
                        </a>
                        <a
                                href="https://plainadmin.com"
                                target="_blank"
                                rel="nofollow noreferrer"
                                class="flex items-center justify-center max-w-[120px] lg:max-w-[130px] xl:max-w-[150px] 2xl:max-w-[160px] mx-3 sm:mx-4 xl:mx-6 2xl:mx-8 py-[15px] grayscale hover:grayscale-0 opacity-60 hover:opacity-100 transition"
                        >
                            <img src="src/images/brands/plainadmin.svg" alt="plainadmin"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    -->
    <!-- ====== Clients Section End  -->

    <!-- ====== CTA Section Start  -->
    <!--
    <section class="mt-[-160px]">
        <div class="container">
            <div class="bg-primary rounded-md relative overflow-hidden z-10 text-center py-[70px]">
                <div class="max-w-[770px] mx-auto px-6 relative z-10">
                    <h2 class="font-bold text-white text-2xl md:text-[40px] leading-tight mb-10">Want to work together
                        and create amazing products?</h2>
                    <form class="relative max-w-[480px] mx-auto">
                        <input
                                type="email"
                                placeholder="Enter your email"
                                class="w-full rounded-full border border-white border-opacity-[13%] bg-white bg-opacity-[15%] px-8 py-4 text-white placeholder-white placeholder-opacity-70 outline-none focus-visible:shadow-none focus:border-opacity-100 transition text-center sm:text-left mb-5 sm:mb-0"
                        />
                        <button class="bg-white text-primary rounded-full font-semibold text-base py-4 sm:py-[10px] px-5 w-full sm:w-auto sm:absolute right-2 top-2">
                            Get a Quote
                        </button>
                    </form>
                </div>

                <div class="absolute bottom-0 left-0 right-0 w-full -z-1">
                    <svg width="818" height="286" viewBox="0 0 818 286" fill="none" xmlns="http://www.w3.org/2000/svg"
                         class="mx-auto">
                        <circle cx="409" cy="409" r="408.5" stroke="url(#paint0_linear_0:1)"/>
                        <circle cx="409" cy="409" r="349.5" stroke="url(#paint1_linear_0:1)"/>
                        <defs>
                            <linearGradient id="paint0_linear_0:1" x1="-34.5" y1="291.5" x2="851" y2="291.5"
                                            gradientUnits="userSpaceOnUse">
                                <stop stop-color="white" stop-opacity="0.35"/>
                                <stop offset="0.218415" stop-color="white" stop-opacity="0"/>
                                <stop offset="0.728079" stop-color="white" stop-opacity="0"/>
                                <stop offset="1" stop-color="white" stop-opacity="0.35"/>
                            </linearGradient>
                            <linearGradient id="paint1_linear_0:1" x1="29.4768" y1="308.45" x2="787.24" y2="308.45"
                                            gradientUnits="userSpaceOnUse">
                                <stop stop-color="white" stop-opacity="0.35"/>
                                <stop offset="0.218415" stop-color="white" stop-opacity="0"/>
                                <stop offset="0.777261" stop-color="white" stop-opacity="0"/>
                                <stop offset="1" stop-color="white" stop-opacity="0.35"/>
                            </linearGradient>
                        </defs>
                    </svg>
                </div>
            </div>
        </div>
    </section>
    -->
    <!-- ====== CTA Section End  -->

    <@sections.team users />

    <!-- ====== Testimonial Section Start  -->
    <!--
    <section id="testimonial" class="pt-[120px] pb-20">
        <div class="container">
            <div class="flex flex-wrap mx-[-16px]">
                <div class="w-full px-4">
                    <div class="max-w-[600px] mx-auto text-center mb-[50px]">
                        <span class="font-semibold text-lg text-primary block mb-2"> TESTIMONIALS </span>
                        <h2 class="font-bold text-black text-3xl sm:text-4xl md:text-[45px] mb-5">Hear From Our
                            Clients</h2>
                        <p class="font-medium text-lg text-body-color">There are many variations of passages of Lorem
                            Ipsum available but the majority have suffered alteration in some form.</p>
                    </div>
                </div>
            </div>

            <div class="flex flex-wrap -mx-4">
                <div class="w-full lg:w-1/2 px-4">
                    <div class="bg-white rounded-xl relative overflow-hidden px-7 sm:px-10 p-10 shadow-testimonial mb-10">
                        <div class="mb-5">
                            <img src="/img/testimonial/company1.svg" alt="company1" class="h-5"/>
                        </div>
                        <p class="font-medium text-lg text-body-color mb-8">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam laoreet tempus augue, ac
                            venenatis lectus tempus ut. Sed sodales erat a libero.
                        </p>
                        <div class="flex items-center">
                            <div class="max-w-[60px] w-full h-[60px] rounded-full overflow-hidden mr-3">
                                <img src="/img/testimonial/image-1.png" alt="image" class="w-full"/>
                            </div>
                            <div>
                                <h3 class="font-semibold text-base text-black mb-1">A cool person</h3>
                                <p class="text-sm text-body-color">Founder @ Groupe MINASTE</p>
                            </div>
                        </div>
                        <div class="absolute bottom-8 right-8">
                            <svg width="51" height="29" viewBox="0 0 51 29" fill="none"
                                 xmlns="http://www.w3.org/2000/svg">
                                <g opacity="0.15">
                                    <path d="M12.4311 0.00142075C7.14984 -0.0798293 2.35609 3.33267 1.21859 7.96392C0.568593 10.8077 1.13734 13.6514 2.84359 15.9264C4.63109 18.3639 7.39359 19.9077 10.4811 20.3139L13.3248 27.3014C13.6498 28.0327 14.3811 28.5202 15.1936 28.5202C16.0061 28.5202 16.7373 28.0327 17.0623 27.3014C17.5498 26.0827 18.1186 24.7827 18.6873 23.5639C20.0686 20.4764 21.4498 17.3077 22.5061 14.0577C23.6436 10.6452 23.1561 6.98892 21.2061 4.22642C19.2561 1.54517 16.1686 0.0826707 12.4311 0.00142075ZM19.8248 13.2452C18.7686 16.3327 17.3873 19.5014 16.0873 22.5077C15.8436 23.1577 15.5186 23.7264 15.2748 24.3764L12.5123 17.7139L11.6186 17.6327C9.01859 17.4702 6.58109 16.1702 5.19984 14.3014C3.98109 12.6764 3.57484 10.6452 4.06234 8.69517C4.87484 5.36392 8.36859 2.92642 12.3498 2.92642H12.4311C15.1936 2.92642 17.4686 4.06392 18.9311 6.01392C20.3123 7.96392 20.6373 10.7264 19.8248 13.2452Z"
                                          fill="#4A6CF7"/>
                                    <path d="M49.0747 4.30772C47.1247 1.54522 44.0372 0.00146484 40.2997 0.00146484C40.2185 0.00146484 40.2185 0.00146484 40.1372 0.00146484C34.9372 0.00146484 30.2247 3.41397 29.0872 7.96397C28.4372 10.8077 29.006 13.6515 30.7122 16.0077C32.4997 18.4452 35.2622 19.989 38.3497 20.3952L41.1935 27.3827C41.5185 28.114 42.2497 28.6015 43.0622 28.6015C43.8747 28.6015 44.606 28.114 44.931 27.3827C45.4185 26.164 45.9872 24.864 46.556 23.6452C47.9372 20.5577 49.3185 17.389 50.3747 14.139C51.5122 10.8077 51.0247 7.07022 49.0747 4.30772ZM47.6935 13.2452C46.6372 16.3327 45.256 19.5015 43.956 22.5077C43.7122 23.1577 43.3872 23.7265 43.1435 24.3765L40.381 17.714L39.4872 17.6327C36.8872 17.4702 34.4497 16.1702 33.0685 14.3015C31.8497 12.6765 31.4435 10.6452 31.931 8.61397C32.7435 5.28272 36.2372 2.84521 40.2185 2.84521H40.2997C43.0622 2.84521 45.3372 3.98272 46.7997 5.93272C48.181 7.96397 48.506 10.7265 47.6935 13.2452Z"
                                          fill="#4A6CF7"/>
                                </g>
                            </svg>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    -->
    <!-- ====== Testimonial Section End  -->

    <!-- ====== Blog Section Start  -->
    <!--
    <section id="news" class="pt-[120px] pb-20 bg-[#f8f9ff]">
        <div class="container">
            <div class="flex flex-wrap mx-[-16px]">
                <div class="w-full px-4">
                    <div class="max-w-[600px] mx-auto text-center mb-[50px]">
                        <span class="font-semibold text-lg text-primary block mb-2"> BLOG </span>
                        <h2 class="font-bold text-black text-3xl sm:text-4xl md:text-[45px] mb-5">Latest Blogs</h2>
                        <p class="font-medium text-lg text-body-color">There are many variations of passages of Lorem
                            Ipsum available but the majority have suffered alteration in some form.</p>
                    </div>
                </div>
            </div>
            <div class="flex flex-wrap -mx-4">
                <div class="w-full lg:w-1/2 xl:w-1/3 px-4">
                    <div class="bg-white rounded-xl overflow-hidden mb-10 shadow-blog">
                        <a href="blog-details.html" class="block">
                            <img src="src/images/news/news-1.jpg" alt="image" class="w-full"/>
                        </a>
                        <div class="py-8 px-6 sm:px-11">
                            <h3>
                                <a href="blog-details.html"
                                   class="font-semibold text-xl text-black hover:text-primary block mb-3 truncate">
                                    UI/UX Design Trend 2024 </a>
                            </h3>
                            <p class="font-medium text-body-color text-base mb-4">Automate your Business for more
                                results, Creating Business that.</p>
                            <a href="blog-details.html"
                               class="font-medium text-sm text-black underline hover:text-primary hover:no-underline">
                                Read More </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    -->
    <!-- ====== Blog Section End  -->

    <@sections.contact />
</@template.page>
