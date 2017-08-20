@import Globalcommon.spec

@objects
	header-image			css		.module-bg-header.wpg-js-bg-paralaxy
	header-imagetext		css		.wpg-mbhc-top>h1
	left_menu_item-*       css     .left.little-menu>ul>li
	section-headers-*       css      .section-header
	right-text-*		    css	      .left.content>p
			
	
=Large hero component=
	header-image:
		width  ~ 1350px
		height ~ 350px
	header-imagetext:
		width  966px
		height 55px
		centered horizontally inside header-image
		text is "Cookie policy"
		css font-size is "50px"
		css font-family starts "Mercury-DisplayRoman"
		
	
		


=left Menu=
	left_menu_item-*: 
		height  41px
		css font-size is "14px"
		css font-family starts "BentonSans-Book"
		
	left_menu_item-1:
		text is "COOKIE POLICY"
		
	left_menu_item-2:
		text is "PRIVACY POLICY"
		
		
	left_menu_item-3:
		text is "TERMS OF USE"
		
		
	
		
	@forEach [left_menu_item-*] as leftMenuItem, prev as previousleftMenuItem
            ${leftMenuItem}:
                aligned vertically right ${previousleftMenuItem}	
= Right Menu =
	right-text-* :
		width 791px
		css font-size is "14px"
		css font-family starts "BentonSans-Book"
	@for [1,2,3,4,5,6] as index
            right-text-${index+1}:
                below section-headers-${(index)} 6px
		
		
	section-headers-* :
		width 791px
		height 15px
		css font-size is "14px"
		css font-family starts "BentonSans-Bold"
		
		
		
		

	
		
		