@import Regionalcommon.spec
@objects
		FocusFundTitle							xpath			//div[@class="wrapper focus-fund"]/h2
		FocusFundTitleUnderLine					css				.little-blue-string
		FocusFundBox-*							css				.fund-item
		FocusFundSmallImage-*					xpath			//div[@class="half"]/div/div[@class="wpg-ico-container"]
		FocusFundBoxTitle-*						css				.fund-header>h2
		FocusFundBoxAmount-*					css				.fund-header>span
		
		FocusFundBoxText-*						css				.fund-header>p
		FocusFundBoxGreyLine-*					css				.little-grey-string
		ShareClassText-*						css				.wrapper>span
		ShareClassSelectBox-*					css				.wpg-plugin-select-simulate
		FundBody-*								css				.additional-info
		
		MidBodyImage							css				.col-xs-12.wpg-check-more-box-js>h2
		CalenderImage							css				.zmdi.zmdi-calendar-note
		MidBodyDate								css				.wpg-mbhc-top>p>span
		AuthorIcon								css				.zmdi.zmdi-account
		LeftArrow								css				.left.carousel-control>i
		RightArrow								css				.right.carousel-control>i
		MidBodyText								css				.col-xs-12.wpg-check-more-box-js>h2
		FundsOfferingTitle						css				.module-header-text>.container>.col-xs-12>h2
		FundsOfferingBox-*						css				.capability-item
		FundsOfferingImages-*					xpath			//div[@class="wrapper wpg-kjknsk"]/div[@class="aligner"]/div[@class="capability-item"]/div[@class="wrapper"]/div
		FundsOfferingTitle-*					css				.capability-item>h3	
		FundsOfferingtexts-*					css				.capability-item>p
		FundsOfferingSmallTitle-*				css				.capability-item>h3	
		DisclosureAndFootNotesTitle				css				.col-xs-12.wpg-check-more-box-js>h2
		DisclosureAndFootNotesTexts				css				.col-xs-12.wpg-check-more-box-js>p
		
		
		



=Body1=
	FocusFundTitle:
			height 28px
			
			css font-size is "25px"
			css font-family starts "BentonSans-Black" 
			
	FocusFundTitleUnderLine:
			height 5px
			width  46px
			below FocusFundTitle 12px
			
			
			
			
			
	FocusFundBox-*:
	
			height 440px
			width  310px
			
			
	FocusFundSmallImage-*:
		height 35px
		width 35px
		
		
		
		
		
	@for [1,2] as index
		FocusFundBox-${index}:
			below FocusFundTitleUnderLine 70px
			
		FocusFundSmallImage-${index}:
			inside FocusFundBox-${index} 0px top left 
			
		FocusFundBoxTitle-${index}:
			inside FocusFundBox-${index} 47px left,36px top
			css font-size is "20px"
			css font-family starts "BentonSans-Black" 
			
		FocusFundBoxAmount-${index}:
			inside FocusFundBox-${index} 1px left
			css font-size is "12px"
			css font-family starts "Mercury-DisplayRoman" 
			
		FocusFundBoxText-${index}:
			inside FocusFundBox-${index} 1px left
			css font-size is "12px"
			css font-family starts "BentonSans-Book" 
			
		FocusFundBoxGreyLine-${index}:
			width 80px
			below FocusFundBoxText-${index} ~30px
			
		ShareClassText-${index}:
			below FocusFundBox-${index} -233px
			css font-size is "12px"
			css font-family starts "Mercury-DisplayRoman"
			
		ShareClassSelectBox-${index}:
			height 43px
			width 274px
			below ShareClassText-${index} 12px
			css font-size is "22px"
			css font-family starts "BentonSans-Book"
			
		FundBody-${index}:
			height 150px
			width 103px
			below ShareClassText-${index} 69px
			
			
	@for [3,4] as index
		FocusFundBox-${index}:
			below FocusFundTitleUnderLine 530px
			
		
			
		FocusFundSmallImage-${index}:
			inside FocusFundBox-${index} 0px top left 
			
		FocusFundBoxTitle-${index}:
			inside FocusFundBox-${index} 47px left,36px top
			css font-size is "20px"
			css font-family starts "BentonSans-Black" 
			
		FocusFundBoxAmount-${index}:
			inside FocusFundBox-${index} 1px left
			css font-size is "12px"
			css font-family starts "Mercury-DisplayRoman" 
			
		FocusFundBoxText-${index}:
			inside FocusFundBox-${index} 1px left
			css font-size is "12px"
			css font-family starts "BentonSans-Book" 
			
		FocusFundBoxGreyLine-${index}:
			width 80px
			below FocusFundBoxText-${index} ~30px
			
		ShareClassText-${index}:
			below FocusFundBox-${index} -233px
			css font-size is "12px"
			css font-family starts "Mercury-DisplayRoman"
			
		ShareClassSelectBox-${index}:
			height 43px
			width 274px
			below ShareClassText-${index} 12px
			css font-size is "22px"
			css font-family starts "BentonSans-Book"
			
		FundBody-${index}:
			height 150px
			width 103px
			below ShareClassText-${index} -391px
	
	MidBodyImage:
		height 29px
		below FundBody-3 ~ 1759px
		
	CalenderImage:
		height 14px
		width  11px
		below MidBodyImage -1099px
		
	MidBodyDate:
		css font-size is "14px"
		css font-family starts "Mercury-DisplayItalic"
		right-of CalenderImage 8px
		
	AuthorIcon:
		height 14px
		width  9px
		below MidBodyImage -1099px
		css font-size is "14px"
		
	LeftArrow:
		height 44px
		width 44px
		below MidBodyImage -2617px
		
	RightArrow:
		height 44px
		width 44px
		below MidBodyImage -2617px
		
	MidBodyText:
		width  944px
		css font-size is "17px"
		css font-family starts "BentonSans-Bold"
		below CalenderImage 1056px
		
	FundsOfferingTitle:
			height 46px
			width 778px
			css font-size is "25px" 
			css font-family starts "BentonSans-Black" 
			
			
	FundsOfferingBox-1:
			
			height ~323px
			width  ~242px
			
			
	FundsOfferingBox-2:
			
			height ~323px
			width  ~242px
			
	FundsOfferingBox-3:
			
			height ~302px
			width  ~242px
			
	FundsOfferingBox-4:
			
			height ~281px
			width  ~242px
			
			
	@forEach [FundsOfferingBox-*] as FundsOfferingBox, prev as previousFundsOfferingBox
		${FundsOfferingBox}:
			aligned horizontally top ${previousFundsOfferingBox}
			
			
	FundsOfferingImages-*:
			height 104px
			width  104px
			css font-size is "54px" 
			css font-family starts "BentonSans-CondensedMedium" 
			
			
			
			
	FundsOfferingImages-1:
			text is "FI"
			
	FundsOfferingImages-2:
			text is "EQ"
			
	FundsOfferingImages-3:
			text is "MA"
			
	FundsOfferingImages-4:
			text is "ALT"
			
	FundsOfferingSmallTitle-*:
			height 23px
			width  218px
			
	FundsOfferingSmallTitle-1:
			text is "Fixed Income"
			
	FundsOfferingSmallTitle-2:
			text is "Equity"
			
	FundsOfferingSmallTitle-3:
			text is "Multi-Asset"
			
	FundsOfferingSmallTitle-4:
			text is "Alternatives"
			
			
	FundsOfferingtexts-*:
	
			width 218px
			css font-size is "14px" 
			css font-family starts "BentonSans-Book" 
			
	DisclosureAndFootNotesTitle:
			css font-size is "17px"
			css font-family starts "BentonSans-Bold"
			
	DisclosureAndFootNotesTexts:
			css font-size is "14px"
			css font-family starts "BentonSans-Book"
			width 944px
			
		
		
		
		
		
	
		
	
		
		
		
			
	
	
	