<template>
  <div>
    <transition>
      <div class="modal-mask">
        <div class="modal-wrapper">
          <div class="modal-container" v-on-clickaway="close">

            <div class="modal-header">
              <slot name="header">

              </slot>
            </div>

            <div class="modal-body">
              <slot name="body">

              </slot>

            </div>
            <div class="modal-footer">
              <slot name="footer">

                <button class="modal-default-button" @click="$emit('close')">
                  Close
                </button>
              </slot>
            </div>

          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
  import { mixin as clickaway } from 'vue-clickaway';
  export default {
    mixins: [ clickaway ],
    name: "modal",
    methods: {
      close(){
        this.$emit('close')
      }
    },
    data () {
      return {
      }
    }
  }
</script>

<style scoped>

</style>
