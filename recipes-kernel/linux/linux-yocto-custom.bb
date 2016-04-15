# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/Freescale/linux-fslc.git;protocol=git;bareclone=1;branch=${KBRANCH}"

SRC_URI += "file://defconfig"

SRC_URI += "file://ntl-saturn-bsp.scc \
            file://ntl-saturn-bsp.cfg \
            file://ntl-saturn-bsp-user-config.cfg \
            file://ntl-saturn-bsp-user-patches.scc \
           "

KBRANCH = "patches-4.1"

LINUX_VERSION ?= "4.1.13"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV="e55a6a92e898a85f47faf04f7e611b931c8c7fe3"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_ntl-saturn-bsp = "ntl-saturn-bsp"
