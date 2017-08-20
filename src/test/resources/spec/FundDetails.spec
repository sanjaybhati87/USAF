@objects		
		
		HeaderImage						css					.wl-fundslider
		
		HeaderInnerBox-*				css					.wl-fundslider__item
		FocusFundSmallImage-*			css					.wl-incomeblock__initials.wl-incomeblock__initials
		FocusFundBoxTitle-*				css					.wl-incomeblock__title		
		FocusFundBoxText-*				css					.wl-incomeblock__summary
		ShareClassText-*				css					.wl-incomeblock__shareclass>label
		ShareClassSelectBox-*			css					#select2-share-class-label-1-container
		InformationBox-*				css					.wl-incomeblock__col	
		HeaderBoxes-*					css					.wl-tab__link
		PlusSign-*						css					.wl-tab__trigger.js-tabTrigger
		HeaderBoxText-*					css					.wl-tab__link>div
		
=Header=

		@on desktop

	 
						HeaderImage:
							height 536px
						
						HeaderInnerBox-1:
							height 421px
							inside partly HeaderImage 65px top
						
						FocusFundSmallImage-1:
							height 35px
							width 35px
							
						FocusFundBoxTitle-1:
							height 70px
							css font-size is "34px"
							
						FocusFundBoxText-1:
							below HeaderImage -400px
							css font-size is "14px"
							css font-family contains "BentonSans-Regular"
							
						ShareClassText-1:
							below FocusFundBoxText-1 72px
							css font-size is "14px"
							css font-family contains "Mercury-DisplayItalic"
							
						ShareClassSelectBox-1:
							height 53px
							width 514px
							below ShareClassText-1 8px
							css font-size is "34px"
							css font-family contains "BentonSans-Regular"
							
						@for [1,2,3,4,5] as index
							InformationBox-${index}:
							
								height 134px
								width 160px
								below ShareClassSelectBox-1 26px
								
								
						
						
						@forEach [HeaderBoxes-*] as HeaderBoxes, prev as previousHeaderBoxes
				        	${HeaderBoxes}:
				        		height 102px
				        		width  958px
				        		aligned vertically left ${previousHeaderBoxes}
				        		aligned vertically right ${previousHeaderBoxes}
				        		below ${previousHeaderBoxes} 42px
				        		
				        PlusSign-*:
				        	height ~40px
				        	width ~40px
				        	
				        HeaderBoxText-*	:
				        	
							css font-size is "25px"
							css font-family contains "BentonSans-Book"
							
							
							
		@on mobile

	 
						HeaderImage:
							height 132% of screen/width 
						
						HeaderInnerBox-1:
							height 123% of screen/width 
							inside partly HeaderImage 15px top
						
						FocusFundSmallImage-1:
							height 35px
							width 35px
							
						FocusFundBoxTitle-1:
							height 21% of screen/width 
							css font-size is "21px"
							
						FocusFundBoxText-1:
							below HeaderImage -342px
							css font-size is "12px"
							css font-family contains "BentonSans-Regular"
							
						ShareClassText-1:
							below FocusFundBoxText-1 70px
							css font-size is "12px"
							css font-family contains "Mercury-DisplayItalic"
							
						ShareClassSelectBox-1:
							height 13% of screen/width 
							width 79% of screen/width 
							below ShareClassText-1 8px
							css font-size is "25px"
							css font-family contains "BentonSans-Regular"
							
					
								
								
						
						
						@forEach [HeaderBoxes-*] as HeaderBoxes, prev as previousHeaderBoxes
				        	${HeaderBoxes}:
				        		height 19% of screen/width 
								width 96% of screen/width
				        		aligned vertically left ${previousHeaderBoxes}
				        		aligned vertically right ${previousHeaderBoxes}
				        		below ${previousHeaderBoxes} 27px
				        		
				        PlusSign-*:
				        	height 36px
				        	width 36px
				        	
				        HeaderBoxText-*	:
				        	
							css font-size is "20px"
							css font-family contains "BentonSans-Book"
							
							
							
							
		@on tab

	 
						HeaderImage:
							height 536px
						
						HeaderInnerBox-1:
							height 421px
							inside partly HeaderImage 65px top
						
						FocusFundSmallImage-1:
							height 35px
							width 35px
							
						FocusFundBoxTitle-1:
							height 70px
							css font-size is "34px"
							
						FocusFundBoxText-1:
							below HeaderImage -400px
							css font-size is "14px"
							css font-family contains "BentonSans-Regular"
							
						ShareClassText-1:
							below FocusFundBoxText-1 70px
							css font-size is "14px"
							css font-family contains "Mercury-DisplayItalic"
							
						ShareClassSelectBox-1:
							height 53px
							width 514px
							below ShareClassText-1 8px
							css font-size is "34px"
							css font-family contains "BentonSans-Regular"
							
						@for [1,2,3,4,5] as index
							InformationBox-${index}:
							
								height 134px
								width 151px
								below ShareClassSelectBox-1 28px
								
								
						
						
						@forEach [HeaderBoxes-*] as HeaderBoxes, prev as previousHeaderBoxes
				        	${HeaderBoxes}:
				        		height 68px
				        		width  757px
				        		aligned vertically left ${previousHeaderBoxes}
				        		aligned vertically right ${previousHeaderBoxes}
				        		below ${previousHeaderBoxes} 42px
				        		
				        PlusSign-*:
				        	height ~36px
				        	width ~36px
				        	
				        HeaderBoxText-*	:
				        	
							css font-size is "20px"
							css font-family contains "BentonSans-Book"
        	
        		
				
				