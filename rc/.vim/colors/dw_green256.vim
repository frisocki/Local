"--------------------------------------------------------------------
" Name Of File: dw_orange.vim.
" Description: Gvim colorscheme, designed against VIM 7.0 GUI
" By: Steve Cadwallader
" Contact: demwiz@gmail.com
" Credits: Inspiration from the brookstream and redblack schemes.
" Last Change: Saturday, September 17, 2006.
" Installation: Drop this file in your $VIMRUNTIME/colors/ directory.
"--------------------------------------------------------------------

set background=dark
hi clear
if exists("syntax_on")
    syntax reset
endif
let g:colors_name="dw_orange"

"--------------------------------------------------------------------

"  item                 cterm                foreground           background          
"  ----                 -----                ----------           ----------          
hi Boolean                                   ctermfg=46                               
hi cDefine                                   ctermfg=46                               
hi cInclude                                  ctermfg=15                               
hi Comment                                   ctermfg=242                              
hi Constant                                  ctermfg=46                               
hi Cursor                                    ctermfg=0            ctermbg=240         
hi CursorColumn                                                   ctermbg=0           
hi CursorLine                                                     ctermbg=233         
hi DiffAdd                                   ctermfg=46           ctermbg=236         
hi DiffChange                                ctermfg=46           ctermbg=236         
hi DiffDelete                                ctermfg=46           ctermbg=236         
hi DiffText                                  ctermfg=15           ctermbg=236         
hi Directory                                 ctermfg=15           ctermbg=0           
hi ErrorMsg                                  ctermfg=0            ctermbg=15          
hi FoldColumn                                ctermfg=9            ctermbg=235         
hi Folded                                    ctermfg=9            ctermbg=235         
hi Function                                  ctermfg=46                               
hi Identifier                                ctermfg=243          ctermbg=0           
hi IncSearch            cterm=none           ctermfg=0            ctermbg=130         
hi LineNr                                    ctermfg=166          ctermbg=0           
hi MatchParen           cterm=none           ctermfg=46           ctermbg=0           
hi ModeMsg                                   ctermfg=202          ctermbg=0           
hi MoreMsg                                   ctermfg=46           ctermbg=0           
hi NonText                                   ctermfg=15           ctermbg=0           
hi Normal               cterm=none           ctermfg=250          ctermbg=0           
hi Operator             cterm=none           ctermfg=242                              
hi PreProc              cterm=none           ctermfg=15                               
hi Question                                  ctermfg=46                               
hi Search               cterm=none           ctermfg=166          ctermbg=0      
hi SignColumn                                ctermfg=15           ctermbg=233         
hi Special              cterm=none           ctermfg=214          ctermbg=0           
hi SpecialKey                                ctermfg=202          ctermbg=0           
hi Statement            cterm=bold           ctermfg=46                              
hi StatusLine           cterm=none           ctermfg=166            ctermbg=0         
hi StatusLineNC         cterm=none           ctermfg=166           ctermbg=0         
hi String               cterm=none           ctermfg=22                              
hi TabLine              cterm=none           ctermfg=0            ctermbg=240         
hi TabLineFill          cterm=underline      ctermfg=15           ctermbg=0           
hi TabLineSel           cterm=none           ctermfg=0            ctermbg=202         
hi Title                cterm=none           ctermfg=15                               
hi Todo                 cterm=none           ctermfg=9            ctermbg=0           
hi Type                 cterm=none           ctermfg=15                               
hi VertSplit            cterm=none           ctermfg=15           ctermbg=0           
hi Visual                                    ctermfg=0            ctermbg=166         
hi WarningMsg                                ctermfg=0            ctermbg=102         

"- end of colorscheme -----------------------------------------------  
