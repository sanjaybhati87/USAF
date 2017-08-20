@import Globalcommon.spec
@objects

		FundCapabiltiesTitle 					xpath 			//*[@class="container"]/div/h2
		FundCapabiltiestext						xpath			//*[@class="container"]/div[@class="col-xs-12"]/p
		InvestmentCapabiltiesImage				xpath			//*[@class="wrapper capabilities"]/div[@class="overlay"]
		InvestmentCapabiltiesTitle				css				.section-header-white		
		InvestmentCapabiltiesBox-*				css				.capability-item
				
		InvestmentCapabiltiesSmallImages-*		xpath			//div[@class="wrapper wpg-kjknsk"]/div[@class="aligner"]/div[@class="capability-item"]/div[@class="wrapper"]/div
		InvestmentCapabiltiesSmallTitle-*		css				.capability-item>h3	
		InvestmentCapabiltiestexts-*			css				.capability-item>p
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
		HistoryBackgroundImage-*				css				.wpg-slide-special-slider-2		
		HistoryTitles-*							xpath			//div[@class="wpg-slide-special-slider-2"]/div[@class="span-table"]/div[@class="span-table-cell vertical-align-middle"]/div[@class="container"]/div/h2	
		HistoryTitles12							css				.container.wpg-lay-type-2>div>h2
		Historytexts-*							xpath			//div[@class="wpg-slide-special-slider-2"]/div[@class="span-table"]/div[@class="span-table-cell vertical-align-middle"]/div[@class="container"]/div/p
		BlogTitle-*								xpath			//div[@class="module-circle-header-text"]/div[@class="container vertical-align-middle-fix"]/div[@class="col-xs-12 col-sm-7 wpg-text-box"]/h2
		BlogText-*								xpath			//div[@class="module-circle-header-text"]/div[@class="container vertical-align-middle-fix"]/div[@class="col-xs-12 col-sm-7 wpg-text-box"]/p
		BlogImage-*								css				.col-xs-12.col-sm-5.wpg-image-box
		RelatedInsightsTitle					xpath			//div[@class="wrapper insights"]/h2
		LeftArrow								css				.zmdi.zmdi-arrow-left.zmdi-hc-2x
		RightArrow								css				.zmdi.zmdi-arrow-right.zmdi-hc-2x
		InsightOuterBox-*						css				.insight
		InsightImage-*							css				.background-photo
		InsightAuthor-*							css				.author
		InsightText-*							css				.article>h4
		CalenderImage-*							xpath			//div[@class="insight"]/div[3]/i
		DateText-*								xpath			//div[@class="insight"]/div[3]/span
		ViewFunds								xpath			//div[@class="container fund-container"]/div[3]/a
		EmailAndContactText-*					css				.email.contact-item>h3
		DisclosureAndFootNotesTitle				css				.col-xs-12.wpg-check-more-box-js>h2
		DisclosureAndFootNotesTexts				css				.col-xs-12.wpg-check-more-box-js>p
		
		
		

		
=Body=

	@on *
			FundCapabiltiesTitle:
		
					height 46px
					width 778px
					css font-size is "25px" 
					css font-family starts "BentonSans-Black" 
					text is "OUR FUND CAPABILITIES"
					
					
			FundCapabiltiestext:
			
					width ~ 778px
					css font-family starts "BentonSans-Book" 
					below FundCapabiltiesTitle 24px
					css font-size is "14px" 
					
	@on mobile, tablet
			
			FundCapabiltiesTitle:
		
					height 46px
					width 70 % of screen/width 
					css font-size is "25px" 
					css font-family starts "BentonSans-Black" 
					text is "OUR FUND CAPABILITIES"
					
			FundCapabiltiestext:
			
					width 90 % of screen/width 
					css font-family starts "BentonSans-Book" 
					below FundCapabiltiesTitle 24px
					css font-size is "14px" 
	
	
	
=Body1=	
	@on *		
			
					
	
										
			InvestmentCapabiltiesImage:
					height 350px
					width  1349px
					below FundCapabiltiestext 86px
					
			InvestmentCapabiltiesTitle:
					height 73px
					width  966px
					css font-size is "50px" 
					css font-family starts "Mercury-DisplayRoman" 
					text is "Investment capabilities"
					inside InvestmentCapabiltiesImage 54px top
					
			InvestmentCapabiltiesBox-1:
					
					height ~323px
					width  ~242px
					
					
			InvestmentCapabiltiesBox-2:
					
					height ~323px
					width  ~242px
					
			InvestmentCapabiltiesBox-3:
					
					height ~302px
					width  ~242px
					
			InvestmentCapabiltiesBox-4:
					
					height ~281px
					width  ~242px
					
			@forEach [InvestmentCapabiltiesBox-*] as InvestmentCapabiltiesBox, prev as previousInvestmentCapabiltiesBox
				${InvestmentCapabiltiesBox}:
					aligned horizontally top ${previousInvestmentCapabiltiesBox}
					
					
			InvestmentCapabiltiesSmallImages-*:
					height 104px
					width  104px
					css font-size is "54px" 
					css font-family starts "BentonSans-CondensedMedium" 
					inside InvestmentCapabiltiesImage 172px top
					
					
					
			InvestmentCapabiltiesSmallImages-1:
					text is "FI"
					
			InvestmentCapabiltiesSmallImages-2:
					text is "EQ"
					
			InvestmentCapabiltiesSmallImages-3:
					text is "MA"
					
			InvestmentCapabiltiesSmallImages-4:
					text is "ALT"
					
			InvestmentCapabiltiesSmallTitle-*:
					height 23px
					width  218px
					
			InvestmentCapabiltiesSmallTitle-1:
					text is "Fixed Income"
					
			InvestmentCapabiltiesSmallTitle-2:
					text is "Equity"
					
			InvestmentCapabiltiesSmallTitle-3:
					text is "Multi-Asset"
					
			InvestmentCapabiltiesSmallTitle-4:
					text is "Alternatives"
					
					
			InvestmentCapabiltiestexts-*:
			
					width 218px
					css font-size is "14px" 
					css font-family starts "BentonSans-Book" 
					inside InvestmentCapabiltiesImage 324px top
					
			
			FocusFundTitle:
					height 28px
					width  1349px
					css font-size is "25px"
					css font-family starts "BentonSans-Black" 
			
					below InvestmentCapabiltiesImage 89 px
					
			FocusFundTitleUnderLine:
					height 5px
					width  46px
					below FocusFundTitle 12px
					
					
			FocusFundBox-*:
			
					height 440px
					width  310px
					below FocusFundTitleUnderLine 70px
					
			FocusFundSmallImage-*:
				height 35px
				width 35px
				
			@for [1,2] as index
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
					below FocusFundBoxText-${index} 30px
					
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
					
			@for [1,2,3,4,5,6,7,8,9,10,11] as index
				
				HistoryBackgroundImage-${index}:
						height 657px
						width 1349px
						
				HistoryTitles-${index}:
						height 94px
						width 944px
						css font-size is "50px"
						css font-family starts "Mercury-DisplayRoman"
						
			@for [1,2,3,4,5,6,7,8,9,10] as index
						
				Historytexts-${index}:
					width 944px
					css font-size is "34px"
					css font-family starts "Mercury-DisplayItalic"	
						
						
			HistoryBackgroundImage-12:
				height 810px
				width 1349px
				
			HistoryTitles12:
				height 94px
				width 944px
				css font-size is "50px"
				css font-family starts "Mercury-DisplayRoman"
				
			BlogTitle-*:
			
				css font-size is "25px"
				css font-family starts "BentonSans-Black"
				
				
			BlogText-*:
				css font-size is "14px"
				css font-family starts "BentonSans-Book"
				
			@for [1,2] as index
				BlogText-${index}:
				 	below BlogTitle-${index} ~43px
				 	
				BlogImage-${index}:
					height ~301px
					width  364px
					left-of BlogText-${index} 11px
				
			RelatedInsightsTitle:
					height 28px
					width 1349px
					css font-size is "25px" 
					css font-family starts "BentonSans-Black" 
					text is "RELATED INSIGHTS"
					below BlogImage-2 150px
			
			LeftArrow:
				height 44px
				width 44px
				below RelatedInsightsTitle 22px
				left-of  RelatedInsightsTitle -252px
				
			RightArrow:
				height 44px
				width 44px
				below RelatedInsightsTitle 22px
				right-of  RelatedInsightsTitle -251px
				
				
				
				
			@for [1,2,3,4,5,6,7,8,9,10,11] as index
				InsightOuterBox-${index}:
				
					height 403px
					width	315px
					left-of InsightOuterBox-${index+1} 22px
					
					
				InsightImage-${index}:
				
					height ~212px
					width	~313px
					left-of InsightOuterBox-${index+1} ~22px
					below InsightOuterBox-${index} ~-402px
					
				InsightAuthor-${index}:
					css font-size is "14px"
					css font-family starts "Mercury-DisplayItalic"
					below InsightOuterBox-${index} ~-182px
					
					
				InsightText-${index}:
					css font-size is "16px"
					css font-family starts "BentonSans-Bold"
					below InsightAuthor-${index} ~ 7px
					
				CalenderImage-${index}:
					height 15px
					width  11px
					below InsightOuterBox-${index} ~-27px
					
				DateText-${index}:
					css font-size is "14px"
					css font-family starts "Mercury-DisplayItalic"
					below CalenderImage-${index} -14px
					
			ViewFunds:
					height 42px
					width	220px
					css font-size is "14px"
					css font-family starts "BentonSans-Bold"
					
			@for [1,2,3] as index		
				EmailAndContactText-${index}:
					css font-size is "16px"
					css font-family starts "BentonSans-Bold"
					aligned horizontally all EmailAndContactText-2 ~3px
					
			DisclosureAndFootNotesTitle:
					css font-size is "17px"
					css font-family starts "BentonSans-Bold"
					
			DisclosureAndFootNotesTexts:
					css font-size is "14px"
					css font-family starts "BentonSans-Book"
					width 944px
					
	@on mobile, tablet
										
			InvestmentCapabiltiesImage:
					InvestmentCapabiltiesImage:
					height 350px
					width 100 % of screen/width 
					below FundCapabiltiestext 86px
					
			InvestmentCapabiltiesTitle:
					height 73px
					width 100 % of screen/width 
					css font-size is "25px" 
					css font-family starts "Mercury-DisplayRoman" 
					text is "Investment capabilities"
					inside InvestmentCapabiltiesImage 54px top
					
			InvestmentCapabiltiesBox-1:
					
					height ~100px
					width 98% of screen/width
					below InvestmentCapabiltiesImage 30px
					
					
			InvestmentCapabiltiesBox-2:
					
					height ~100px
					width 98% of screen/width
					below InvestmentCapabiltiesBox-1 0px
					
			InvestmentCapabiltiesBox-3:
					
					height ~100px
					width 98% of screen/width
					below InvestmentCapabiltiesBox-1 0px
					
			InvestmentCapabiltiesBox-4:
					
					height ~100px
					width 98% of screen/width
					below InvestmentCapabiltiesBox-1 0px
					
			@forEach [InvestmentCapabiltiesBox-*] as InvestmentCapabiltiesBox, prev as previousInvestmentCapabiltiesBox
				${InvestmentCapabiltiesBox}:
					aligned vertically left ${previousInvestmentCapabiltiesBox}
					
					
			InvestmentCapabiltiesSmallImages-*:
					height 30px
					width  30px
					css font-size is "25px" 
					css font-family starts "BentonSans-CondensedMedium" 
					inside InvestmentCapabiltiesImage 172px top
					
					
					
			InvestmentCapabiltiesSmallImages-1:
					text is "FI"
					
			InvestmentCapabiltiesSmallImages-2:
					text is "EQ"
					
			InvestmentCapabiltiesSmallImages-3:
					text is "MA"
					
			InvestmentCapabiltiesSmallImages-4:
					text is "ALT"
					
			InvestmentCapabiltiesSmallTitle-*:
					height 23px
					width  218px
					
			InvestmentCapabiltiesSmallTitle-1:
					text is "Fixed Income"
					
			InvestmentCapabiltiesSmallTitle-2:
					text is "Equity"
					
			InvestmentCapabiltiesSmallTitle-3:
					text is "Multi-Asset"
					
			InvestmentCapabiltiesSmallTitle-4:
					text is "Alternatives"
					
					
			InvestmentCapabiltiestexts-*:
			
					width 92% of screen/width
					css font-size is "14px" 
					css font-family starts "BentonSans-Book" 
					Below InvestmentCapabiltiesSmallTitle-* 32px 
					
			
			FocusFundTitle:
					height 28px
					width 92% of screen/width
					css font-size is "25px"
					css font-family starts "BentonSans-Black" 
					below InvestmentCapabiltiestexts-4 89 px
					
			FocusFundTitleUnderLine:
					height 5px
					width 12% of screen/width
					below FocusFundTitle 12px
					
					
			FocusFundBox-*:
			
					height 440px
					width 96% of screen/width
					below FocusFundTitleUnderLine 34px
					
			FocusFundSmallImage-*:
				height 35px
				width 35px
				
			@for [1,2] as index
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
					width 80% of screen/width
					below FocusFundBoxText-${index} 20px
					
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
					
		
				
				RelatedInsightsTitle:
					height 28px
					width 100% of screen/width
					css font-size is "25px" 
					css font-family starts "BentonSans-Black" 
					text is "RELATED INSIGHTS"
					below BlogImage-2 150px
			
			
				
				
				
				
			@for [1,2,3,4,5,6,7,8,9,10,11] as index
				InsightOuterBox-${index}:
				
					height 403px
					width 96% of screen/width
					left-of InsightOuterBox-${index+1} 22px
					
					
				InsightImage-${index}:
				
					height ~212px
					width 98% of screen/width
					left-of InsightOuterBox-${index+1} ~22px
					below InsightOuterBox-${index} ~-402px
					
				InsightAuthor-${index}:
					css font-size is "14px"
					css font-family starts "Mercury-DisplayItalic"
					below InsightOuterBox-${index} ~-182px
					
					
				InsightText-${index}:
					css font-size is "16px"
					css font-family starts "BentonSans-Bold"
					below InsightAuthor-${index} ~ 7px
					
				CalenderImage-${index}:
					height 15px
					width  11px
					below InsightOuterBox-${index} ~-27px
					
				DateText-${index}:
					css font-size is "14px"
					css font-family starts "Mercury-DisplayItalic"
					below CalenderImage-${index} -14px
					
			ViewFunds:
					height 42px
					width 88% of screen/width
					css font-size is "14px"
					css font-family starts "BentonSans-Bold"
					
			@for [1,2,3] as index		
				EmailAndContactText-${index}:
					css font-size is "16px"
					css font-family starts "BentonSans-Bold"
					aligned verically left EmailAndContactText-2 ~3px
					
			DisclosureAndFootNotesTitle:
					css font-size is "17px"
					css font-family starts "BentonSans-Bold"
					
			DisclosureAndFootNotesTexts:
					css font-size is "14px"
					css font-family starts "BentonSans-Book"
					width 98% of screen/width
					
		
			
			
		
			
			
			
			
		
			
				
			
		
			
			

		
		
		
	
		
	
		
	
	
			
			
			
			
			
			
			
	
			
			
	
			
			
			
	
			
			
			
	
			
			
	
	
			
			
			
	
			
	
			
			
		
			