"--------------------------------------------------------------------
" Name Of File: brookstream.vim.
" Description: Gvim colorscheme, works best with version 6.1 GUI .
" Maintainer: Peter Bäckström.
" Creator: Peter Bäckström.
" URL: http://www.brookstream.org (Swedish).
" Credits: Inspiration from the darkdot scheme.
" Last Change: Friday, April 13, 2003.
" Installation: Drop this file in your $VIMRUNTIME/colors/ directory.
"--------------------------------------------------------------------

set background=dark
if exists("syntax_on")
    syntax reset
endif
let g:colors_name="brookstream256"

"--------------------------------------------------------------------

hi Normal                               ctermbg=0 ctermfg=250     gui=none       guibg=#000000  guifg=#bbbbbb  
hi Cursor                               ctermfg=0       guibg=#44ff44  guifg=#000000  
hi Directory                            ctermfg=87      guifg=#44ffff  
hi DiffAdd                              ctermfg=11      guibg=#080808  guifg=#ffff00  
hi DiffDelete                           ctermfg=238     guibg=#080808  guifg=#444444  
hi DiffChange                           ctermfg=15      guibg=#080808  guifg=#ffffff  
hi DiffText                             ctermfg=124     guibg=#080808  guifg=#bb0000  
hi ErrorMsg                             ctermfg=15      guibg=#880000  guifg=#ffffff  
hi Folded                               ctermfg=18      guifg=#000088  
hi IncSearch                            ctermfg=251     guibg=#000000  guifg=#bbcccc  
hi LineNr                               ctermfg=67      guibg=#050505  guifg=#4682b4  
hi ModeMsg                              ctermfg=15      guifg=#ffffff  
hi MoreMsg                              ctermfg=83      guifg=#44ff44  
hi NonText                              ctermfg=12      guifg=#4444ff  
hi Question                             ctermfg=11      guifg=#ffff00  
hi SpecialKey                           ctermfg=12      guifg=#4444ff  
hi StatusLine                           ctermfg=15      gui=none       guibg=#2f4f4f  guifg=#ffffff  
hi StatusLineNC                         ctermfg=0       gui=none       guibg=#bbbbbb  guifg=#000000  
hi Title                                ctermfg=15      guifg=#ffffff  
hi Visual                               ctermfg=0       gui=none       guibg=#bbbbbb  guifg=#000000  
hi WarningMsg                           ctermfg=11      guifg=#ffff00  

" syntax highlighting groups ----------------------------------------

hi Comment                              ctermfg=242     guifg=#696969  
hi Constant                             ctermfg=37      guifg=#00aaaa  
hi Identifier                           ctermfg=45      guifg=#00e5ee  
hi Statement                            ctermfg=14      guifg=#00ffff  
hi PreProc                              ctermfg=99      guifg=#8470ff  
hi Type                                 ctermfg=15      guifg=#ffffff  
hi Special                              ctermfg=117     gui=none       guifg=#87cefa  
hi Underlined                           ctermfg=12      gui=bold       guifg=#4444ff  
hi Ignore                               ctermfg=238     guifg=#444444  
hi Error                                ctermfg=124     guibg=#000000  guifg=#bb0000  
hi Todo                                 ctermfg=11      guibg=#aa0006  guifg=#fff300  
hi Operator                             ctermfg=39      gui=none       guifg=#00bfff  
hi Function                             ctermfg=33      guifg=#1e90ff  
hi String                               ctermfg=67      gui=None       guifg=#4682b4  
hi Boolean                              ctermfg=114     guifg=#9bcd9b  

"hi link Character Constant
"hi link Number    Constant
"hi link Boolean   Constant
"hi link Float   Number
"hi link Conditional Statement
"hi link Label   Statement
"hi link Keyword   Statement
"hi link Exception Statement
"hi link Repeat    Statement
"hi link Include   PreProc
"hi link Define    PreProc
"hi link Macro   PreProc
"hi link PreCondit PreProc
"hi link StorageClass  Type
"hi link Structure Type
"hi link Typedef   Type
"hi link Tag   Special
"hi link Delimiter Special
"hi link SpecialComment  Special
"hi link Debug   Special
"hi link FoldColumn  Folded

"- end of colorscheme -----------------------------------------------	

